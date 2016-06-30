package com.java7.concurrent.additional.case01;

import java.util.Date;

/**
 * Created by Administrator on 2016/6/22.
 */
public class Case01 {
    public static void main(String[] args) {
        BuildStats stats=new BuildStats();
        Sensor1 sensor1=new Sensor1(stats);
        Thread thread1=new Thread(sensor1,"Sensor 1");
        Sensor2 sensor2=new Sensor2(stats);
        Thread thread2=new Thread(sensor2,"Sensor 2");
        Date date1=new Date();
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date2=new Date();
        stats.printStats();
        System.out.println("Execution Time: "+ ((date2.getTime()-
                date1.getTime())/1000));
    }
}
