package com.java7.current.chapter7.case7_5;

import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/5/27.
 */
public class MyTask implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
