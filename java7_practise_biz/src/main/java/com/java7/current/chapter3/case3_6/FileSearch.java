package com.java7.current.chapter3.case3_6;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/25.
 */
public class FileSearch implements Runnable{
    private String initPath;
    private String end;
    private List<String> results;
    private Phaser phaser;

    public FileSearch(String initPath, String end, Phaser phaser ) {
        this.initPath = initPath;
        this.end = end;
        this.phaser = phaser;
        results = new ArrayList<String>();
    }

    public void directorProcess(File file) {
        File[] list = file.listFiles();
        if(list != null) {
            for(int i=0; i<list.length; i++ ) {
                if(list[i].isDirectory()) {
                    directorProcess(list[i]);
                } else {
                    fileProcess(list[i]);
                }
            }
        }
    }

    private void fileProcess(File file) {
        if(file.getName().endsWith(end)) {
            results.add(file.getAbsolutePath());
        }
    }

    private void filterResults() {
        List<String> newResults = new ArrayList<String>();
        long actualDate = new Date().getTime();
        for(int i =0; i<results.size(); i++) {
            File file = new File(results.get(i));
            long fileDate = file.lastModified();
            if(actualDate-fileDate < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
                newResults.add(results.get(i));
            }
        }
        results = newResults;
    }

    private boolean checkResult() {
        if(results.isEmpty()) {
            System.out.printf("%s Phase %d: 0 result .\n", Thread.currentThread().getName(), phaser.getPhase());
            System.out.printf("%s Phase %d End. \n", Thread.currentThread().getName(), phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            return false;
        } else {
            System.out.printf("%s: Phase %d: end .\n", Thread.currentThread().getName(), results.size());
            phaser.arriveAndAwaitAdvance();
            return true;
        }
    }

    private void showInfo() {
        for(int i=0; i<results.size(); i++) {
            File file = new File(results.get(i));
            System.out.printf("%s: %s\n", Thread.currentThread().getName(), file.getAbsoluteFile());
        }
        phaser.arriveAndAwaitAdvance();
    }

    public void run() {
        phaser.arriveAndAwaitAdvance(); // phaser若被终止返回一个负数
        System.out.printf("%s: Starting \n", Thread.currentThread().getName());
        File file = new File(initPath);
        if(file.isDirectory()) {
            directorProcess(file);
        }
        if(!checkResult()) {
            return;
        }
        filterResults();
        if(!checkResult()) {
            return;
        }
        showInfo();
        phaser.arriveAndDeregister(); // 撤销线程的注册
        System.out.printf("%s Work completed .\n", Thread.currentThread().getName());
    }
}
