package com.java7.concurrent.chapter4.case4_9;

import java.util.concurrent.Callable;

/**
 * Created by lenovo on 2016/5/1.
 */
public class Task implements Callable<String> {

    public String call() throws Exception {
        while(true) {
            System.out.printf("Main: Executing the test.\n");
            Thread.sleep(100);
        }
    }
}
