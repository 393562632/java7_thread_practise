package com.java7.current.chapter1.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/7.
 */
public class SafeTask implements Runnable {
    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
        protected Date initialValue() {
            return new Date();
        }
    };
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get() );
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Ending Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get() );

    }
}
