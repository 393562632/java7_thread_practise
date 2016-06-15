package com.java7.current.chapter7.case7_11;

/**
 * Created by jackeyChen on 2016/6/15.
 */
public class Case7_11  {
    public static void main(String[] args) {
        ParkingCounter counter = new ParkingCounter(5);
        Sensor1 sensor1 = new Sensor1(counter);
        Sensor2 sensor2 = new Sensor2(counter);
        Thread thread1 = new Thread(sensor1);
        Thread thread2 = new Thread(sensor2);
        thread1.start();
        thread2.start();
        try {
            thread2.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: number of cars: %d\n", counter.get());
        System.out.printf("Main: End of the Program.\n");
    }
}
