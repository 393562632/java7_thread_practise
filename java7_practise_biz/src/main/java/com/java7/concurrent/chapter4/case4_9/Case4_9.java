package com.java7.concurrent.chapter4.case4_9;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/28.
 */
public class Case4_9 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Task task = new Task();
        System.out.printf("Main: Excuting the task.\n");
        Future<String> result = executor.submit(task);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Canceling the Task.\n");
        result.cancel(true);
        System.out.printf("Main: Canceled: %s.\n", result.isCancelled());
        System.out.printf("Main: Done: %s.\n", result.isDone());
        executor.shutdown();
        System.out.printf("Main: the executor has finnished.\n");
        /*
        如果你使用Future对象的get()方法来控制一个已被取消的任务，这个get()方法将抛出CancellationException异常。
         */
    }
}
