package com.java7.concurrent.chapter6.case6_9;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by jackeychen on 2016/5/23.
 */
public class Decrementer implements Runnable {
    private AtomicIntegerArray vector;

    public Decrementer(AtomicIntegerArray vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int i = 0; i < vector.length(); i++) {
            vector.getAndDecrement(i);
        }
    }
}
