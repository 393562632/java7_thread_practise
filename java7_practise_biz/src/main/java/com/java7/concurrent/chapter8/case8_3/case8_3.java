package com.java7.concurrent.chapter8.case8_3;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/20.
 */
public class case8_3 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors. newCachedThreadPool();
        Random random=new Random();
        for (int i=0; i<10; i++) {
            Task task=new Task(random.nextInt(10000));
            executor.submit(task);
        }

        for (int i=0; i<5; i++){
            showLog(executor);
            TimeUnit.SECONDS.sleep(1);
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
        System.out.printf("Main: End of the program");

    }

    private static void showLog(ThreadPoolExecutor executor) {
        System.out.printf("*********************\n");
        System.out.printf("Main: Executor Log");
        System.out.printf("Main: Executor: Core Pool Size:%d\n", executor.getCorePoolSize());
        System.out.printf("Main: Executor: Pool Size: %d\n", executor.getPoolSize());
        System.out.printf("Main: Executor: Active Count:%d\n", executor.getActiveCount());
        System.out.printf("Main: Executor: Task Count: %d\n", executor.getTaskCount());
        System.out.printf("Main: Executor: Complete task Count%d\n", executor.getCompletedTaskCount());
        System.out.printf("Main: Executor: Shutdown: %s\n", executor.isShutdown());
        System.out.printf("Main: Executor: Terminating: %s\n", executor.isTerminated());
        System.out.printf("Main: Executor: Terminated: %s\n", executor.isTerminated());
        System.out.printf("********************\n");
    }
}
