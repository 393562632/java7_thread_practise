package com.java7.concurrent.chapter6.case6_9;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by jackeyChen on 2016/5/23.
 */
public class Incrementer implements Runnable {
    private AtomicIntegerArray vector;

    public Incrementer(AtomicIntegerArray vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int i = 0; i < vector.length(); i++) {
            vector.getAndIncrement(i);
        }
    }
}
