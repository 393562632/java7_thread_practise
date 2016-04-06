package com.java7.current.chapter1.service;

import com.java7.current.util.FileUtil;

import java.io.File;

/**
 * Created by dell on 2016/4/5.
 */
public class FileSearch implements Runnable {

    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if(file.isDirectory()) {
            try {
                FileUtil.directoryProcess(file, fileName);
            } catch (InterruptedException e) {
                System.out.printf("%s : the search has been interrupted ", Thread.currentThread().getName());
                e.printStackTrace();
            }
        }
    }
}
