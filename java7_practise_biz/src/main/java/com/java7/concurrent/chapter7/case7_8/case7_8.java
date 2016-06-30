package com.java7.concurrent.chapter7.case7_8;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/6/8.
 */
public class case7_8 {
    public static void main(String[] args) {
        int[] arrary = new int[10000];
        ForkJoinPool pool = new ForkJoinPool();
        Task task = new Task("Task", arrary, 0, arrary.length);
        pool.invoke(task);
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Fork of the program");
    }
}
