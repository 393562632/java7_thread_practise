package com.java7.current.chapter7.case7_5;

import java.util.concurrent.*;

/**
 * Created by jackeyChen on 2016/5/30.
 */
public class Case7_5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
        ExecutorService executor = Executors.newCachedThreadPool(threadFactory);
        MyTask task = new MyTask();
        executor.submit(task);
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: End of the program.\n");
    }
}
