package com.java7.current.chapter5.case5_3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/5/6.
 */
public class Case5_3 {
    public static void main(String[] args) {
        DocumentMock mock = new DocumentMock();
        String[][] document = mock.generateDocument(100 , 1000, "the");
        DocumentTask task = new DocumentTask(document, 0, 100, "the");
        ForkJoinPool pool = new ForkJoinPool();
        //采用同步的方式执行任务并返回结果。直到任务完成后才有结果返回，可以实现工作窃取算法来调度任务去执行。
        pool.execute(task);
        do{
            System.out.printf("***************************\n");
            System.out.printf("Main： Parallelism: %d\n.", pool.getParallelism());
            System.out.printf("Main:  Active Threads: %d\n.", pool.getActiveThreadCount());
            System.out.printf("Main:  Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main:  Steal Count: %d\n", pool.getStealCount());
            System.out.printf("***************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(!task.isDone());
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.printf("Main： The word appears %d in the document", task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
