package com.java7.concurrent.chapter2.case2_6;

/**
 * Created by lenovo on 2016/4/14.
 */
public class Writer implements Runnable {
    private PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    public void run() {
        for(int i=0; i<3; i++) {
            System.out.printf("Writer Attempt to midify the price.\n");
            pricesInfo.setPrice(Math.random()*10, Math.random()*8);
            System.out.printf("Writer Price have been modified.\n");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
