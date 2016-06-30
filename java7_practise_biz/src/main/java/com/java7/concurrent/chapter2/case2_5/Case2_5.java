package com.java7.concurrent.chapter2.case2_5;

/**
 * Created by lenovo on 2016/4/14.
 */
public class Case2_5 {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread thread[] = new Thread[10];
        for(int i=0; i<10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread" + i);
        }
        for(int i=0; i<10; i++) {
            thread[i].start();
        }
    }
}
