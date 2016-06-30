package com.java7.concurrent.chapter1.service;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/12.
 */
public class TaskForCase1_13 implements Runnable {
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
