package com.java7.current.chapter2.case2_8;


import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lenovo on 2016/4/15.
 */
public class Buffer {

    private LinkedList<String> buffer;
    private int maxSize;
    private ReentrantLock lock;
    private Condition lines;
    private Condition space;
    private boolean pendingLines; //用来表示缓冲区是否有数据

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<String>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    public void insert(String line) {
        lock.lock();
        try {
            while(buffer.size() == maxSize) {
                 space.await();
            }
            buffer.offer(line);
            System.out.printf("%s: Inserted Line %d\n", Thread.currentThread().getName(), buffer.size());
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String get() {
        String line = null;
        lock.lock();
        try {
            while((buffer.size() == 0)&& hasappendingLines()) {
                lines.await();
            }
            if(hasappendingLines()) {
                line = buffer.poll();
                System.out.printf("%s: Line Readed %d\n", Thread.currentThread().getName(),buffer.size());
                space.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return line;
    }

    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }

    public boolean hasappendingLines() {
        return pendingLines || buffer.size()>0;
    }
}
