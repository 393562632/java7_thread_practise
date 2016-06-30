package com.java7.concurrent.chapter2.case2_4;

/**
 * Created by lenovo on 2016/4/13.
 */
public class Case2_4 {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Thread thread1 = new Thread(producer);
        Consumer consumer = new Consumer(eventStorage);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}
