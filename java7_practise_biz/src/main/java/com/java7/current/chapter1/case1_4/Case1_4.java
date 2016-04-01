package com.java7.current.chapter1.case1_4;

import com.java7.current.chapter1.service.PrimeGenerator;

/**
 * Created by dell on 2016/4/5.
 */
public class Case1_4 {
    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}