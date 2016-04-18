package com.java7.current.chapter3.case3_4;

/**
 * Created by lenovo on 2016/4/20.
 */
public class Case3_4 {
    public static void main(String[] args) {

        VideoConference conference = new VideoConference(10);
        Thread threadConference = new Thread(conference);
        threadConference.start();
        for(int i =0; i<10; i++) {
            Participant p = new Participant(conference, "Participant"+i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}
