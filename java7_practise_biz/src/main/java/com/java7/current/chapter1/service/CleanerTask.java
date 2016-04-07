package com.java7.current.chapter1.service;

import com.java7.current.model.Event;

import java.util.Date;
import java.util.Deque;

/**
 * Created by lenovo on 2016/4/7.
 */
public class CleanerTask extends Thread {
    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    public void run() {
        while(true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;
        if(deque.size() == 0) return;
        delete = true;
        do {
            Event event = deque.getLast();
            difference = date.getTime() - event.getDate().getTime();
            if(difference > 10000) {
                System.out.printf("Cleaner ： %s\n", event.getEvent());
                deque.removeLast();
                delete = true;
            }
        }while(difference > 10000);
        if(delete) {
            System.out.printf("Cleaner : size of the queue: %d\n", deque.size());
        }
    }


}
