package com.java7.concurrent.chapter3.case3_2;

import java.util.concurrent.Semaphore;

/**
 * Created by lenovo on 2016/4/18.
 */
public class PrintQueue {
    private final Semaphore semaphore;

    public PrintQueue() {
        this.semaphore = new Semaphore(1);
    }

    public void PrintJob(Object object) {
        try {
            semaphore.acquire();
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: print a job during %d deconds\n ",
                    Thread.currentThread().getName(), duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
