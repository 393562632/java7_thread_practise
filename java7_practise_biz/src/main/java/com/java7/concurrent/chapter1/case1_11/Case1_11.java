package com.java7.concurrent.chapter1.case1_11;

import com.java7.concurrent.chapter1.service.SearchTask;
import com.java7.concurrent.model.Result;
import com.java7.concurrent.util.ThreadInfo;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/8.
 */
public class Case1_11 {
    public static void main(String[] args) {
        //创建线程组并启动
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);
        for(int i=0; i<5; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //打印线程组相关信息
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("number of thread %s\n", threadGroup.activeCount());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("Information about the thread Group\n");
        threadGroup.list();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for(int i = 0; i< threadGroup.activeCount(); i++) {
            System.out.printf("thread  %s: %s\n", threads[i].getName(), threads[i].getState());
        }
        System.out.println("++++++++++++++++++wait finish+++++++++++++++++++++++++++");
        ThreadInfo.waitFinish(threadGroup);
        System.out.println("++++++++++++++++++thread interrupt+++++++++++++++++++++++++++");
        threadGroup.interrupt();
    }
}
