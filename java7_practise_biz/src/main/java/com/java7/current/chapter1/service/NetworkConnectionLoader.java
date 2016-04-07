package com.java7.current.chapter1.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/7.
 */
public class NetworkConnectionLoader implements Runnable {
    public void run() {
        System.out.printf("Beginning net work loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data net work finished %s\n", new Date());
    }
}
