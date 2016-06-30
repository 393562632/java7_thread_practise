package com.java7.concurrent.chapter3.case3_2;

/**
 * Created by lenovo on 2016/4/18.
 */
public class Case3_2 {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread thread[] = new Thread[10];
        for(int i =0; i<10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread" + i);
        }
        for(int i=0; i<10; i++) {
            thread[i].start();
        }
    }
}
