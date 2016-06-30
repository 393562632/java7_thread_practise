package com.java7.concurrent.chapter8.case8_6;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/6/21.
 */
public class Case8_6 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            Task task = new Task(lock);
            Thread thread = new Thread(task);
            thread.run();
        }
    }
}
