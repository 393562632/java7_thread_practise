package com.java7.current.chapter1.service;

import com.java7.current.util.NumberUtil;

/**
 * Created by dell on 2016/4/5.
 */
public class PrimeGenerator extends Thread{

    @Override
    public void run() {
        long number = 1L;
        while(true) {
            if(NumberUtil.isPrime(number)) {
                System.out.println("Number  " + number + "  is a prime");
            }
            if(isInterrupted()) {
                System.out.println("The PrimeGenerator has been interrupted");
                return;
            }
            number++;
        }
    }
}
