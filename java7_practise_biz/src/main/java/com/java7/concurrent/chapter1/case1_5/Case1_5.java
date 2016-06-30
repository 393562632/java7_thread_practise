package com.java7.concurrent.chapter1.case1_5;

import com.java7.concurrent.chapter1.service.FileSearch;

import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2016/4/5.
 */
public class Case1_5 {
    public static void main(String[] agrs) {
        FileSearch fileSearch = new FileSearch("C:\\", "autoexec.bat");
        Thread thread = new Thread(fileSearch);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
