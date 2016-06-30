package com.java7.concurrent.chapter1.case1_8;

import com.java7.concurrent.chapter1.service.CleanerTask;
import com.java7.concurrent.chapter1.service.WriterTask;
import com.java7.concurrent.model.Event;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by lenovo on 2016/4/7.
 */
public class Case1_8 {
    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<Event>();
        WriterTask writer = new WriterTask(deque);
        for(int i = 0; i<3; i++) {
            Thread thread = new Thread(writer);
            thread.start();
        }
        CleanerTask cleanerTask = new CleanerTask(deque);
        cleanerTask.start();
    }
}
