package com.java7.current.chapter1.service;

/**
 * Created by dell on 2016/4/1.
 */
public class Calculator implements Runnable{

    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for(int i=0; i<=10; i++) {
            int temp = i*number;
            System.out.println( "Thread" + Thread.currentThread().getId()+ ":" + number + "*" + i + "="+ temp);
        }
    }
}
