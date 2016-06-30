package com.java7.concurrent.chapter1.case1_12;

import com.java7.concurrent.chapter1.service.MyThreadGroup;
import com.java7.concurrent.chapter1.service.TaskForCase1_12;

/**
 * Created by lenovo on 2016/4/11.
 */
public class Case1_12 {
    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        TaskForCase1_12 task = new TaskForCase1_12();
        for(int i=0; i<2; i++) {
            Thread t = new Thread(threadGroup, task);
            t.start();
        }
    }
}
