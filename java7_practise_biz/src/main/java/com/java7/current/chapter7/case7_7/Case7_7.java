package com.java7.current.chapter7.case7_7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/6/6.
 */
public class Case7_7 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyWorkerThreadFactory factory = new MyWorkerThreadFactory();
        ForkJoinPool pool = new ForkJoinPool(4, factory, null, false);
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        MyRecursiveTask task = new MyRecursiveTask(array, 0, array.length);
        pool.execute(task);
        task.join();
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (task.isCompletedAbnormally()) {
            System.out.printf("Main: An exception has occurred\n");
            task.getException().printStackTrace();
        }
        System.out.printf("Main : Result: %d\n", task.get());
        System.out.printf("Main: End of the program\n");
    }
}
