package com.java7.current.additional.case01;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/22.
 */
public class BuildStats {
    private long numPeople;

    public /*synchronized*/ void comeIn(){
        System.out.printf("%s: A person enters.%n", Thread.
                currentThread().getName());
        synchronized (this) {
            numPeople++;
        }
        generateCard();
    }

    public /*synchronized*/ void goOut(){
        System.out.printf("%s: A person leaves.%n", Thread.
                currentThread().getName());
        synchronized (this) {
            numPeople--;
        }
        generateReport();
    }

    private void generateCard(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void generateReport(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printStats(){
        System.out.printf("%d persons in the building.%n", numPeople);
    }

}
