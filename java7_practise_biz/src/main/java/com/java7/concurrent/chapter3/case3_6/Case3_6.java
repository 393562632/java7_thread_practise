package com.java7.concurrent.chapter3.case3_6;

import java.util.concurrent.Phaser;

/**
 * Created by jackeyChen on 2016/4/25.
 */
public class Case3_6 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        FileSearch system = new FileSearch("C:\\Windows", "log", phaser);
        FileSearch apps = new FileSearch("C:\\Program Files", "log", phaser);
        FileSearch documents = new FileSearch("C:\\Users", "log", phaser);
        Thread systemThread = new Thread(system, "System");
        systemThread.start();
        Thread appThread = new Thread(apps, "Apps");
        appThread.start();
        Thread documentsThread = new Thread(documents, "Documents");
        documentsThread.start();
        try {
            systemThread.join();
            appThread.join();
            documentsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Terminated: " + phaser.isTerminated() + "\n");
    }
}
