package com.java7.concurrent.chapter3.case3_4;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lenovo on 2016/4/20.
 */
public class VideoConference implements Runnable{

    private final CountDownLatch controller;

    public VideoConference(int number) {

        this.controller = new CountDownLatch(number);

    }

    public void arrive(String name) {

        System.out.printf("%s has arrived", name);
        controller.countDown();
        System.out.printf("VideoConference: Wait for %d participant. \n", controller.getCount());

    }

    public void run() {

        System.out.printf("VideoConference: Waiting for %d participants\n", controller.getCount());
        try {
            controller.await();
            System.out.printf("VideoConference: Initialization: %d  participants\n ", controller.getCount());
            System.out.printf("VideoConference: let us start .........\n");
        } catch (InterruptedException e) {

        } finally {
        }

    }
}
