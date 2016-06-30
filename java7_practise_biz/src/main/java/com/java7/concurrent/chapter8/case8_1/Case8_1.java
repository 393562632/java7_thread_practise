package com.java7.concurrent.chapter8.case8_1;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/6/17.
 */
public class Case8_1 {
    public static void main(String[] args) {
        MyLock lock = new MyLock();
        Thread threads[] = new Thread[5];
        for(int i=0; i<5; i++) {
            Task task = new Task(lock);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for(int i=0; i<15; i++) {
            //把锁的拥有者写入控制台。
            System.out.printf("Main: Logging the lock\n");
            System.out.printf("Main:**********************\n");
            System.out.printf("Main: Lock: Owner：%s\n", lock.getOwnerName());
            //显示锁queued的线程号码和名字
            System.out.printf("Main: Lock: Queue Threads: %s\n", lock.hasQueuedThreads());
            if(lock.hasQueuedThreads()) {
                System.out.printf("Main:Lock: Queued Length: %d\n", lock.getQueueLength());
                System.out.printf("Main:Lock: Queue Threads:");
                Collection<Thread> lockedThreads = lock.getThreads();
                for(Thread lockThread : lockedThreads ) {
                    System.out.printf("%s", lockThread.getName());
                }
                System.out.printf("\n");
            }
            System.out.printf("Main:Lock: Fairness: %s\n", lock.isFair());
            System.out.printf("Main:Lock: Locked: %s\n", lock.isLocked());
            System.out.printf("*********************************\n");
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
