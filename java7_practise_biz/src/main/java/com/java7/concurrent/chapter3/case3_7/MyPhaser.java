package com.java7.concurrent.chapter3.case3_7;

import java.util.concurrent.Phaser;

/**
 * Created by jackeyChen on 2016/4/25.
 */
public class MyPhaser extends Phaser {
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.printf("Phaser: the number of registeredParties is %d.\n", registeredParties);
        switch (phase) {
            case 0:
                return studentArrived();
            case 1:
                return finishFirstExcercise();
            case 2:
                return finishSecondExcerise();
            case 3:
                return finishExam();
            default:
                return true;
        }
    }

    private boolean studentArrived() {
        System.out.printf("Phaser: The exam are going to start. the student are ready. \n" );
        System.out.printf("Phaser: We have %d students. \n", getRegisteredParties());
        return false;
    }

    private boolean finishFirstExcercise() {
        System.out.printf("Phaser: All the students have finished the first exercise. \n" );
        System.out.printf("Phaser: It's time for the second one. \n" );
        return false;
    }

    private boolean finishSecondExcerise() {
        System.out.printf("Phaser: All the students have finished the second exercise. \n" );
        System.out.printf("Phaser: It's time for the third one. \n" );
        return false;
    }

    private boolean finishExam() {
        System.out.printf("Phaser: All the students have finished the exam. \n" );
        System.out.printf("Phaser: Thank you for your time. \n" );
        return false;
    }
}
