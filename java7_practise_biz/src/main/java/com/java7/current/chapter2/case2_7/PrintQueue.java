package com.java7.current.chapter2.case2_7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lenovo on 2016/4/14.
 */
public class PrintQueue {
    private final Lock queueLock = new ReentrantLock(true);
    public void printJob(Object document) {
        queueLock.lock();
        try {
            Long duration = (long) (Math.random()*10000);
            System.out.println(Thread.currentThread().getName() +
                    "PrintQueue: Printing a job during " +
                    (duration/10000) + "seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }

        queueLock.lock();
        try {
            Long duration = (long) (Math.random()*10000);
            System.out.println(Thread.currentThread().getName() +
                    "PrintQueue: Printing a job during " +
                    (duration/10000) + "seconds");
            Thread.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
