package com.java7.current.chapter3.case3_5;

/**
 * Created by jackeyChen on 2016/4/22.
 */
public class Grouper implements Runnable{
    private Results result;

    public Grouper(Results result) {
        this.result = result;
    }

    public void run() {
        int finalResult = 0;
        System.out.printf("Grouper: Processing result: ...........\n");
        int data[] = result.getdata();
        for(int number: data) {
            finalResult+=number;
        }
        System.out.printf("Grouper: Total result: %d.\n", finalResult);
    }
}
