package com.java7.current.chapter6.case6_7;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by lenovo on 2016/5/20.
 */
public class TaskLocalRandom implements Runnable {

    public TaskLocalRandom() {
        ThreadLocalRandom.current();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for(int i=0; i<10; i++) {
            System.out.printf("%s: %d\n", name, ThreadLocalRandom.current().nextInt(10));
        }
    }
}
