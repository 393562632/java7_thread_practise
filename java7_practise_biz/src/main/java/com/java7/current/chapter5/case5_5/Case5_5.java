package com.java7.current.chapter5.case5_5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/5/16.
 */
public class Case5_5 {
    public static void main(String[] args) {
        int arrary[] = new int[100];
        Task task = new Task(arrary, 0, 100);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(task.isCompletedAbnormally()) {
            System.out.printf("Main: An exception has occurred\n");
            task.getException().printStackTrace();
        }
        System.out.printf("Main: Result", task.join());
    }
}
