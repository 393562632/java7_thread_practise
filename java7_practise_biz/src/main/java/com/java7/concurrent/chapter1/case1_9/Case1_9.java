package com.java7.concurrent.chapter1.case1_9;

import com.java7.concurrent.chapter1.service.Task;
import com.java7.concurrent.handler.ExecptionHandler;

/**
 * Created by lenovo on 2016/4/7.
 */
public class Case1_9 {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();
        thread.setUncaughtExceptionHandler(new ExecptionHandler());
    }
}
