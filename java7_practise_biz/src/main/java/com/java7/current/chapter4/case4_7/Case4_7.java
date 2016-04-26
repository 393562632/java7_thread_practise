package com.java7.current.chapter4.case4_7;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/28.
 */
public class Case4_7 {
    public static void main(String[] args) {
        ScheduledExecutorService executor = (ScheduledExecutorService) Executors.newScheduledThreadPool(1);
        System.out.printf("Main: Starting at: %s\n", new Date());
        for(int i=0; i<5; i++) {
            Task task = new Task("Task" + i);
            executor.schedule(task, i+1, TimeUnit.SECONDS);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Ends at:", new Date());
    }
}
