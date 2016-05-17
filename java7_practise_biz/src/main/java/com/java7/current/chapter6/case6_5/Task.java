package com.java7.current.chapter6.case6_5;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/5/18.
 */
public class Task implements Runnable {
    private int id;
    private DelayQueue<Event> queue;

    public Task(int id, DelayQueue<Event> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        Date now = new Date();
        Date delay = new Date();
        delay.setTime(now.getTime() + (id * 1000));
        System.out.printf("Thread %s : %s \n", id, delay);
        for (int i = 0; i < 100; i++) {
            Event event = new Event(delay);
            queue.add(event);
        }
    }
}
