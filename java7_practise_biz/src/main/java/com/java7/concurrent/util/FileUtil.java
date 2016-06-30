package com.java7.concurrent.util;

import java.io.File;

/**
 * Created by dell on 2016/4/5.
 */
public class FileUtil {
    public static void directoryProcess(File file, String fileName) throws InterruptedException {
        File fileList[] = file.listFiles();
        if(fileList != null) {
            for(int i=0; i<fileList.length; i++) {
                if(fileList[i].isDirectory()) {
                    directoryProcess(fileList[i], fileName);
                } else {
                    fileprocess(fileList[i], fileName);
                }
            }
        }
        if(Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    public static void fileprocess(File file, String fileName) throws InterruptedException {
        if(file.getName().equals(fileName)) {
            System.out.printf("%s:  %s \n", Thread.currentThread(), file.getAbsoluteFile());
        }
        if(Thread.interrupted()) {
            throw new InterruptedException();
        }
    }
}
