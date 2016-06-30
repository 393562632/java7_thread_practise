package com.java7.concurrent.chapter4.case4_12;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/5/4.
 */
public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task" + name + "Starting");
        try {
            long duration = (long)(Math.random() * 10);
            System.out.printf("Task %s: ReportGenerator: Generating a report during %d seconds\n", name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("Task %s: ending\n", name);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                '}';
    }
}