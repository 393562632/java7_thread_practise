package com.java7.current.chapter7.case7_4;

import java.util.concurrent.ThreadFactory;

/**
 * Created by jackeyChen on 2016/5/27.
 */
public class MyThreadFactory implements ThreadFactory {
    private int counter;
    private String prefix;

    public MyThreadFactory(String prefix) {
        this.prefix = prefix;
        counter = 1;
    }

    @Override
    public Thread newThread(Runnable r) {
        MyThread myThread = new MyThread(r, prefix + "-" + counter);
        counter++;
        return myThread;
    }
}
