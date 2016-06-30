package com.java7.concurrent.chapter1.service;

/**
 * Created by lenovo on 2016/4/7.
 */
public class Task implements Runnable {
    public void run() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        int number = Integer.parseInt("TTTT");
        System.out.printf("++++++++++++++++++++++++++++++++++++++");
    }
}
