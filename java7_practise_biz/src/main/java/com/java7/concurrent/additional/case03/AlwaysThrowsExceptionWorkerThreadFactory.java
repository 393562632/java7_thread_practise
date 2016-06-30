package com.java7.concurrent.additional.case03;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * Created by Administrator on 2016/6/24.
 */
public class AlwaysThrowsExceptionWorkerThreadFactory implements ForkJoinPool.ForkJoinWorkerThreadFactory {
    /**
     * It receives a ForkJoinPool object
     * as a parameter and returns a ForkJoinWorkerThread object. Create an
     * AlwaysThrowsExceptionWorkerThread object and return it.
     * @param pool
     * @return
     */
    @Override
    public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
        return new AlwaysThrowsExceptionWorkerThread(pool);
    }
}
