package com.java7.current.chapter4.case4_8;

import java.util.Date;

/**
 * Created by jackeyChen on 2016/4/28.
 */
public class Task implements Runnable{
    private String name;


    public Task(String name) {
        this.name = name;
    }

    public void run() {
        System.out.printf("%s: Starting at : %s\n", name, new Date());
    }
}
