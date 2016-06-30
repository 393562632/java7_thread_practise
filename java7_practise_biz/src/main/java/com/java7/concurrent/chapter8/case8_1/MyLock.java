package com.java7.concurrent.chapter8.case8_1;

import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jackeyChen on 2016/6/17.
 */
public class MyLock extends ReentrantLock {

    public String getOwnerName() {
        if (this.getOwner() == null) {
            return "None";
        }
        return this.getOwner().getName();
    }

    //返回在锁里面的线程Queued
    public Collection<Thread> getThreads() {
        return this.getQueuedThreads();
    }
}
