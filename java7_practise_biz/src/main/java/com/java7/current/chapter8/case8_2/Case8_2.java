package com.java7.current.chapter8.case8_2;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/6/17.
 */
public class Case8_2 {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(3);
        for(int i=0; i<3; i++) {
            Task task = new Task(i+1, phaser);
            Thread thread = new Thread(task);
            thread.start();
        }
        for(int i=0; i<10; i++) {
            System.out.printf("*****************\n");
            System.out.printf("Main: Phaser Log\n");
            System.out.printf("Main: Phaser: Phase: %d\n", phaser.getPhase());
            System.out.printf("Main: Phaser: Registered Parties: %d\n", phaser.getRegisteredParties());
            System.out.printf("Main: Phaser: Arrive Parities: %d\n", phaser.getArrivedParties());
            System.out.printf("Main: Phaser: Unarrives Parities %d\n", phaser.getUnarrivedParties());
            System.out.printf("******************\n");
            TimeUnit.SECONDS.sleep(1);
        }

    }
}
