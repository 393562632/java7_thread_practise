package com.java7.concurrent.handler;

/**
 * Created by lenovo on 2016/4/7.
 */
public class ExecptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An execption has been captured\n");
        System.out.printf("Thread: %s\n", t.getId());
        System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
        e.printStackTrace();
        System.out.printf("Thread status: %s\n", t.getState());
    }
}
