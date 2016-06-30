package com.java7.concurrent.chapter1.service;

import com.java7.concurrent.model.Event;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/7.
 */
public class WriterTask implements Runnable {
    private Deque<Event> deque;



    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    public void run() {
        for(int i=0; i<100; i++) {
            Event event;
            event = new Event();
            event.setDate( new Date());
            event.setEvent(String.format("the thread %s has generate an event", Thread.currentThread().getId()));
            deque.addFirst(event);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("writer end ..................");

    }
}
