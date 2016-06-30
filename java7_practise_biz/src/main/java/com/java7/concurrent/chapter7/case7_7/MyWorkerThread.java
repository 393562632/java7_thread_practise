package com.java7.concurrent.chapter7.case7_7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * Created by jackeyChen on 2016/6/7.
 */
public class MyWorkerThread extends ForkJoinWorkerThread {

    private static ThreadLocal<Integer> taskCounter = new ThreadLocal<Integer>();

    /**
     * Creates a ForkJoinWorkerThread operating in the given pool.
     *
     * @param pool the pool this thread works in
     * @throws NullPointerException if pool is null
     */
    protected MyWorkerThread(ForkJoinPool pool) {
        super(pool);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.printf("MyWorkerThread %d: Initializing task counter.\n", getId());
        taskCounter.set(0);
    }

    @Override
    protected synchronized void onTermination(Throwable exception) {
        System.out.printf("MyWorker Thread %d: %d\n", getId(), taskCounter.get());
        super.onTermination(exception);
    }

    public synchronized int addTask() {
        int counter = taskCounter.get().intValue();
        counter++;
        taskCounter.set(counter);
        return counter;
    }

    public synchronized void setTask(int value) {
        taskCounter.set(value);
    }

    public synchronized int getTask() {
        return taskCounter.get().intValue();
    }
}
