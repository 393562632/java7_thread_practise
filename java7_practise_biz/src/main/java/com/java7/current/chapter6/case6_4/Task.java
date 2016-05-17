package com.java7.current.chapter6.case6_4;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by lenovo on 2016/5/18.
 */
public class Task implements Runnable {
    private int id;
    private PriorityBlockingQueue<Event> queue;

    public Task(int id, PriorityBlockingQueue<Event> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i=0; i<1000; i++) {
            Event event = new Event(id, i);
            queue.add(event);
        }
    }
}
