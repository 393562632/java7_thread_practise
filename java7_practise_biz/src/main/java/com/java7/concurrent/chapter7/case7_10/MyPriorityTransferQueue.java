package com.java7.concurrent.chapter7.case7_10;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jackeyChen on 2016/6/14.
 */
public class MyPriorityTransferQueue<E> extends PriorityBlockingQueue<E> implements TransferQueue<E> {
    //正在等待的消费者的数量
    private AtomicInteger counter;
    private LinkedBlockingDeque<E> transfered;
    private ReentrantLock lock;

    public MyPriorityTransferQueue() {
        counter = new AtomicInteger(0);
        lock = new ReentrantLock();
        transfered = new LinkedBlockingDeque<E>();
    }

    @Override
    public boolean tryTransfer (E e) {
        lock.lock();
        boolean value;
        if(counter.get() == 0) {
            value = false;
        } else {
            put(e);
            value = true;
        }
        lock.unlock();
        return value;
    }

    //如果资源不够把数据放入queue,并调用await方法，直到数据被消费者消耗掉。
    @Override
    public void transfer(E e) throws InterruptedException {
        lock.lock();
        if(counter.get() != 0) {
            put(e);
            lock.unlock();
        } else {
            transfered.add(e);
            lock.unlock();
            synchronized (e) {
                e.wait();
            }
        }
    }

    //在特定时间内传给消费者数据
    @Override
    public boolean tryTransfer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        lock.lock();
        if(counter.get() != 0) {
            put(e);
            lock.unlock();
            return true;
        } else {
            transfered.add(e);
            long newTimeOut = TimeUnit.MILLISECONDS.convert(timeout, unit);
            lock.unlock();
            e.wait(newTimeOut);
            lock.lock();
            if(transfered.contains(e)) {
                transfered.remove(e);
                lock.unlock();
                return false;
            } else {
                lock.unlock();
                return true;
            }
        }
    }

    //队列中是否有数据去提供给消费者
    @Override
    public boolean hasWaitingConsumer() {
        return (counter.get() != 0);
    }

    @Override
    public int getWaitingConsumerCount() {
        return counter.get();
    }

    @Override
    public E take() throws InterruptedException {
        lock.lock();
        counter.incrementAndGet();
        E value = transfered.poll();
        if(value == null) {
            lock.unlock();
            value = super.take();
            lock.lock();
        } else {
            synchronized (value) {
                value.notify();
            }
        }
        counter.decrementAndGet();
        lock.unlock();
        return value;
    }
}
