package com.java7.concurrent.additional.case05;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/24.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s: %d\n",Thread.currentThread().getName(),i);
        }

    }
}
