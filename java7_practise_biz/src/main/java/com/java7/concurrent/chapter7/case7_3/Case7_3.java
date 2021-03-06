package com.java7.concurrent.chapter7.case7_3;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/5/27.
 */
public class Case7_3 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());
        for (int i = 0; i<4; i++) {
            MyPriorityTask task = new MyPriorityTask("Task" + i, i);
            executor.execute(task);
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 4; i<8; i++) {
            MyPriorityTask task = new MyPriorityTask("Task" + i, i);
            executor.execute(task);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: End of the program");
    }
}
