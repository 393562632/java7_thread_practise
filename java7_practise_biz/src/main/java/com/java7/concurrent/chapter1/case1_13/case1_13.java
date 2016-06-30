package com.java7.concurrent.chapter1.case1_13;

import com.java7.concurrent.chapter1.service.MyThreadFactory;
import com.java7.concurrent.chapter1.service.TaskForCase1_13;

/**
 * Created by lenovo on 2016/4/11.
 */
public class case1_13 {
    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory("MyThreadFactory");
        TaskForCase1_13 task =new TaskForCase1_13();
        Thread thread;
        System.out.println("starting the thread\n");
        for(int i=0; i<10; i++) {
            thread = myThreadFactory.newThread(task);
            thread.start();
        }
        System.out.println("Factory status");
        System.out.printf("%s \n", myThreadFactory.getStat());
    }
}
