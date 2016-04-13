package com.java7.current.chapter2.case2_4;

/**
 * Created by lenovo on 2016/4/13.
 */
public class Consumer implements Runnable {

    private EventStorage eventStorage;

    public Consumer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    public void run() {
        for(int i=0; i<100; i++) {
            eventStorage.get();
        }
    }
}
