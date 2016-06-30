package com.java7.concurrent.chapter6.Case6_7;


/**
 * Created by jackeyChen on 2016/5/20.
 */
public class Case6_7 {
    public static void main(String[] args) {
        Thread threads[] = new Thread[3];
        for (int i = 0; i < 3; i++) {
            TaskLocalRandom task = new TaskLocalRandom();
            threads[i] = new Thread(task);
            threads[i].start();
        }
    }
}
