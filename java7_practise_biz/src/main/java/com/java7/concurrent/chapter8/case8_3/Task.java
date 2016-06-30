package com.java7.concurrent.chapter8.case8_3;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/20.
 */
public class Task implements Runnable {

    private long millisends;

    public Task(long millisends) {
        this.millisends = millisends;
    }

    public void run() {
        System.out.printf("%s: Begin\n",Thread.currentThread(). getName());
        try {
            TimeUnit.MILLISECONDS.sleep(millisends);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: End\n",Thread.currentThread(). getName());
    }

}
