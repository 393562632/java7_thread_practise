package com.java7.current.chapter4.case4_7;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by lenovo on 2016/4/28.
 */
public class Task implements Callable<String>{
     private String name;

    public Task(String name) {
        this.name = name;
    }

    public String call() throws Exception {
        System.out.printf("%s: Starting at: %s\n", name, new Date());
        return "Hello world.";
    }
}
