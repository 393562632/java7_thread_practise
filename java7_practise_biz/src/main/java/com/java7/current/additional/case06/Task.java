package com.java7.current.additional.case06;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/30.
 */
public class Task implements Runnable{
    private Semaphore semaphore;

    public Task(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.printf("%s: Get the semaphore.\n",Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName()+": Release the semaphore.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }
}
