package com.java7.concurrent.chapter6.case6_2;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by lenovo on 2016/5/17.
 */
public class AddTask implements Runnable {
    private ConcurrentLinkedDeque<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000; i++) {
            list.add(name + ": Element" + i);
        }
    }
}
