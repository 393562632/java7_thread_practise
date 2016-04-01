package com.java7.current.chapter1.case1_7;

import com.java7.current.chapter1.service.DataSourcesLoader;
import com.java7.current.chapter1.service.NetworkConnectionLoader;

import java.util.Date;

/**
 * Created by lenovo on 2016/4/7.
 */
public class Case1_7 {
    public static void main(String[] args) {
        DataSourcesLoader ds = new DataSourcesLoader();
        NetworkConnectionLoader nc = new NetworkConnectionLoader();
        Thread thread  = new Thread(ds, "DataSourcesLoader");
        Thread thread2 = new Thread(nc, "NetworkConnectionLoader");
        thread.start();
        thread2.start();
        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("All the sub work has benn loaded : %s\n", new Date());
    }
}
