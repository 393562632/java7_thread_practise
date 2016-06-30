package com.java7.concurrent.chapter3.case3_4;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/20.
 */
public class Participant implements Runnable {

    private VideoConference conference;
    private String name;

    public Participant(VideoConference vonference, String name) {
        this.conference = vonference;
        this.name = name;
    }

    public void run() {
        long duration = (long)(Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conference.arrive(name);
    }
}
