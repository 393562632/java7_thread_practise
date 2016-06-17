package com.java7.current.additional.case01;

/**
 * Created by Administrator on 2016/6/22.
 */
public class Sensor1 implements Runnable {
    private BuildStats stats;

    public Sensor1(BuildStats stats) {
        this.stats = stats;
    }

    @Override
    public void run() {
        stats.comeIn();
        stats.comeIn();
        stats.comeIn();
        stats.goOut();
        stats.comeIn();
    }
}
