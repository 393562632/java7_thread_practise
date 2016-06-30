package com.java7.concurrent.design.case04;

import java.util.concurrent.locks.Lock;

/**
 * Created by Administrator on 2016/6/30.
 */
public class Task2 implements Runnable {
    private Lock lock;

    public Task2(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        Operations.readData();
        lock.unlock();
        Operations.processData();
        lock.lock();
        Operations.writeData();
        lock.unlock();
    }
}
