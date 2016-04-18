package com.java7.current.chapter3.case3_3;

/**
 * Created by lenovo on 2016/4/18.
 */
public class Case3_3 {
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
