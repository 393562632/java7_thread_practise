package com.java7.concurrent.chapter7.case7_6;

import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/5/31.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        System.out.printf("Task: Begin.\n");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Task: End.\n");
    }
}
