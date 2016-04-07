package com.java7.current.chapter1.case1_10;

import com.java7.current.chapter1.service.SafeTask;
import com.java7.current.chapter1.service.UnsafeTask;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/7.
 */
public class CoreSafe {
    public static void main(String[] args) {
        SafeTask safeTask = new SafeTask();
        for(int i =0; i<3 ;i++) {
            Thread thread = new Thread(safeTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
