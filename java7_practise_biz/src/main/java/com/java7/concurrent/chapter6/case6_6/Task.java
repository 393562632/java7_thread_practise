package com.java7.concurrent.chapter6.case6_6;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by lenovo on 2016/5/19.
 */
public class Task implements Runnable {
    private ConcurrentSkipListMap<String, Contact> map;
    private String id;
    int counter = 0;
    Thread threads[] = new Thread[25];

    public Task(ConcurrentSkipListMap<String, Contact> map, String id) {
        this.map = map;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Contact contact = new Contact(id, String.valueOf(i + 1000));
            map.put(id + contact.getPhone(), contact);
        }
    }
}