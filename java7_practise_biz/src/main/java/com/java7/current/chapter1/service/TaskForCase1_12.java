package com.java7.current.chapter1.service;

import java.util.Random;

/**
 * Created by lenovo on 2016/4/11.
 */
public class TaskForCase1_12 implements Runnable {
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while(true) {
            result = 1000/(int)(random.nextDouble()*1000);
            System.out.printf("%s : %d\n", Thread.currentThread().getId(), result );
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d :  Interrupted\n", Thread.currentThread().getId());
                return ;
            }
        }
    }
}
