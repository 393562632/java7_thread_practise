package com.java7.concurrent.additional.case01;

/**
 * Created by Administrator on 2016/6/22.
 */
public class Sensor2 implements Runnable{
    private BuildStats stats;

    public Sensor2(BuildStats stats) {
        this.stats = stats;
    }

    @Override
    public void run() {
        stats.comeIn();
        stats.comeIn();
        stats.goOut();
        stats.goOut();
        stats.goOut();
    }
}
