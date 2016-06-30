package com.java7.concurrent.chapter2.case2_6;

/**
 * Created by lenovo on 2016/4/14.
 */
public class Reader implements Runnable {
    private PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    public void run() {
        for(int i =0; i<10; i++) {
            System.out.printf("%s: Price1: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice1());
            System.out.printf("%s: Price2: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice2());
        }
    }
}
