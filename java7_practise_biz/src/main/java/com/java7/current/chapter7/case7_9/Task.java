package com.java7.current.chapter7.case7_9;

import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/6/13.
 */
public class Task implements Runnable{
    private MyLock lock;
    private String name;

    public Task( String name, MyLock lock) {
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.printf("Task: %s: Take the lock\n", name);
        try{
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("Task: %s: Free the lock\n",name);
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
