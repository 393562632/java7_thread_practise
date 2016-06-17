package com.java7.current.chapter8;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Created by jackeyChen on 2016/6/17.
 */
public class Task implements Runnable {

    private Lock lock;

    public Task(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //获取锁并打印信息
            lock.lock();
            System.out.printf("%s: Get the lock.\n", Thread.currentThread().getName());
            //释放锁并打印信息
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.printf("%s: Free the Lock\n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
