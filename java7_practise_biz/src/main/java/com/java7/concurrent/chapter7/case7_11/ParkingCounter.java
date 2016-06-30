package com.java7.concurrent.chapter7.case7_11;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jackeyChen on 2016/6/16.
 */
public class ParkingCounter extends AtomicInteger {
    private int maxNumber;

    public ParkingCounter(int maxNumber) {
        set(0);
        this.maxNumber = maxNumber;
    }

    public Boolean carIn() {
        for (; ; ) {
            int value = get();
            if (value == maxNumber) {
                System.out.printf("ParkingCounter: the parking lot is full.\n");
                return false;
            } else {
                int newValue = value + 1;
                boolean changed = compareAndSet(value, newValue);
                if(changed){
                    System.out.printf("ParkingCounter: A car has entered\n");
                    return true;
                }
            }
        }
    }


    public Boolean carOut() {
        for(;;){
            int value = get();
            if(value == 0) {
                System.out.printf("ParkingCounter: The parking lot is empty");
                return false;
            } else {
                int newValue = value - 1;
                boolean changed = compareAndSet(value, newValue);
                if(changed) {
                    System.out.printf("ParkingCounter: A car has gone out\n");
                    return true;
                }
            }
        }
    }
}
