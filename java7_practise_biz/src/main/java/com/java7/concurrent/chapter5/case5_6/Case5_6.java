package com.java7.concurrent.chapter5.case5_6;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/5/16.
 */
public class Case5_6 {
    public static void main(String[] args) {
        ArrayGenerator generator = new ArrayGenerator();
        int arrary[] = generator.generateArrary(1000);
        TaskManager manager = new TaskManager();
        ForkJoinPool pool = new ForkJoinPool();
        SearchNumberTask task = new SearchNumberTask(arrary, 0, 1000, 5, manager);
        pool.execute(task);
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: The Program has finished\n");
    }
}
