package com.java7.current.additional.case03;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * Created by Administrator on 2016/6/24.
 */
public class AlwaysThrowsExceptionWorkerThread extends ForkJoinWorkerThread {
    /**
     * Creates a ForkJoinWorkerThread operating in the given pool.
     *
     * @param pool the pool this thread works in
     * @throws NullPointerException if pool is null
     */
    protected AlwaysThrowsExceptionWorkerThread(ForkJoinPool pool) {
        super(pool);
    }

    /**
     * Implement the onStart() method. This is a method of the
     * ForkJoinWorkerThread class and is executed when the worker thread begins its
     * execution. The implementation will throw a RuntimeException exception upon
     * being called.
     */
    @Override
    protected void onStart() {
        super.onStart();
        throw new RuntimeException("Exception from worker thread");
    }
}
