package com.java7.concurrent.chapter1.service;

import com.java7.concurrent.model.Result;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/8.
 */
public class SearchTask implements Runnable {

    private Result result;

    public SearchTask(Result result) {
        this.result = result;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s: Start\n", name);
        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doTask() throws InterruptedException{
        Random random = new Random((new Date()).getTime());
        int value = (int) (random.nextDouble() * 100);
        System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(),value);
        TimeUnit.SECONDS.sleep(value);
    }
 }
