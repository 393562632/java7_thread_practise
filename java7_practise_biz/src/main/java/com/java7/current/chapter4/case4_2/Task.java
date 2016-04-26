package com.java7.current.chapter4.case4_2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/26.
 */
public class Task implements Runnable{
    private Date initDate;
    private String name;

    public Task(String name) {
        this.initDate = new Date();
        this.name = name;
    }

    public void run() {
        System.out.printf("%s Task %s: Create on: %s\n", Thread.currentThread().getName(), name, initDate);
        System.out.printf("%s Task %s: Start  on: %s\n", Thread.currentThread().getName(), name, new Date());
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.printf("%s: Task %s: Doing a task during %d second\n", Thread.currentThread().getName(), name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Task %s: Finished on: %s\n", Thread.currentThread().getName(), name, new Date());
    }
}
