package com.java7.concurrent.design.case03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/6/30.
 */
public class TaskLock implements Runnable {
    private Lock lock;
    private int number;

    public TaskLock() {
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        for (int i=0; i<1000000; i++) {
            lock.lock();
            number=i;
            lock.unlock();
        }
    }
}
