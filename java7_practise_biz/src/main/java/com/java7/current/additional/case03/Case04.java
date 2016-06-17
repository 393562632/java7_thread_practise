package com.java7.current.additional.case03;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/23.
 */
public class Case04 {
    public static void main(String[] args) {
        OneSecondLongTask task=new OneSecondLongTask();
        Handler handler = new Handler();
        AlwaysThrowsExceptionWorkerThreadFactory factory=new AlwaysThrowsExceptionWorkerThreadFactory();
        ForkJoinPool pool=new ForkJoinPool(2,factory,handler,false);
        pool.execute(task);
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Task: Finish.\n");
    }
}
