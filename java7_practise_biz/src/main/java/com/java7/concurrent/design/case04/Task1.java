package com.java7.concurrent.design.case04;

import java.util.concurrent.locks.Lock;

/**
 * Created by Administrator on 2016/6/30.
 */
public class Task1 implements Runnable{
    private Lock lock;

    public Task1 (Lock lock) {
        this.lock=lock;
    }

    @Override
    public void run() {
        lock.lock();
        Operations.readData();
        Operations.processData();
        Operations.writeData();
        lock.unlock();
    }
}
