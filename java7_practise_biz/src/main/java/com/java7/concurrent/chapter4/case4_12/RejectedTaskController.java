package com.java7.concurrent.chapter4.case4_12;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by lenovo on 2016/5/4.
 */
public class RejectedTaskController implements RejectedExecutionHandler{
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("RejectedTaskController: the task %s has been rejected\n", r.toString());
        System.out.printf("RejectedTaskController: %s\n", executor.toString());
        System.out.printf("RejectedTaskController: Terminated: %s\n", executor.isTerminated());
        System.out.printf("RejectedTaskController: Terminating: %s\n", executor.isTerminating());
    }
}
