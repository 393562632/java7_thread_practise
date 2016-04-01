package com.java7.current.chapter1.case1_10;

import com.java7.current.chapter1.service.UnsafeTask;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/7.
 */
public class Core {
    public static void main(String[] args) {
        UnsafeTask unsafeTask = new UnsafeTask();
        for(int i =0; i<10 ;i++) {
            Thread thread = new Thread(unsafeTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
