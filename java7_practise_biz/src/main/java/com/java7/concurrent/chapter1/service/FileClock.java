package com.java7.concurrent.chapter1.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/7.
 */
public class FileClock implements Runnable {
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.printf("%s\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.printf("The FileCLock has been interrupted");
            }
        }
    }
}
