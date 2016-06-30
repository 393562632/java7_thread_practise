package com.java7.concurrent.design.case03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2016/6/30.
 */
public class TaskAtomic implements Runnable {
    private AtomicInteger number;

    public TaskAtomic() {
        this.number = new AtomicInteger();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            number.set(i);
        }
    }
}
