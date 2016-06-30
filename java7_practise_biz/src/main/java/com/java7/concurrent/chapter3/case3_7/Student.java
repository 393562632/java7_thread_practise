package com.java7.concurrent.chapter3.case3_7;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/4/25.
 */
public class Student implements Runnable{
    private Phaser phaser;

    public Student(Phaser phaser) {
        this.phaser = phaser;
    }

    public void run() {
        System.out.printf("%s: Has arrived to do the exame. %s \n.", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Is going to do the first excerise. %s\n", Thread.currentThread().getName(), new Date());
        doExercise1();
        System.out.printf("%s: has done the first excerise. %s \n.", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Is going to do the second excerise. %s\n", Thread.currentThread().getName(), new Date());
        doExercise2();
        System.out.printf("%s: has done the second excerise. %s \n.", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Is going to do the finished excerise. %s\n", Thread.currentThread().getName(), new Date());
        doExercise3();
        System.out.printf("%s: has finished the excerise. %s \n.", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
        phaser.arriveAndDeregister();
    }

    private void doExercise1() {
        try {
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doExercise2() {
        try {
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doExercise3() {
        try {
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
