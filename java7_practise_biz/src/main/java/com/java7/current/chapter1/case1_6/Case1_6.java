package com.java7.current.chapter1.case1_6;

import com.java7.current.chapter1.service.FileClock;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/7.
 */
public class Case1_6 {
    public static void main(String[] args) {
        FileClock fc = new FileClock();
        Thread thread = new Thread(fc);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

}
