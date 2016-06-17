package com.java7.current.additional.case03;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/24.
 */
public class OneSecondLongTask extends RecursiveAction {
    @Override
    protected void compute() {
        System.out.printf("Task: Starting.\n");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Task: Finish.\n");
    }
}
