package com.java7.current.chapter6.case6_2;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by jackeyChen on 2016/5/17.
 */
public class PollTask implements Runnable {
    private ConcurrentLinkedDeque<String> list;

    public PollTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            list.pollFirst();
            list.pollLast();
        }
    }
}
