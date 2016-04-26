package com.java7.current.chapter4.case4_10;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/5/2.
 */
public class ExecutableTask implements Callable<String>{
    private String name;

    public ExecutableTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String call() {
        try {
            long duration=(long)(Math.random()*10);
            System.out.printf("%s: Waiting %d seconds for results.\n",this.name,duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, world. I'm "+ name;
    }
}
