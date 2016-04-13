package com.java7.current.chapter2.case2_5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lenovo on 2016/4/14.
 */
public class PrintQueue {
    private final Lock queueLock = new ReentrantLock();
    public void printJob(Object document) {
        queueLock.lock();
        try {
            Long duration =  (long) (Math.random() * 1000);
            System.out.printf(Thread.currentThread().getName() +
                    ": PrintQueue: Printing a job during  " +
                    (duration/1000) + "seconds\n");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
