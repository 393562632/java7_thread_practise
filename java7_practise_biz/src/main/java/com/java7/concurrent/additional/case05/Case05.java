package com.java7.concurrent.additional.case05;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/24.
 */
public class Case05 {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread[] = new Thread[5];
        for (int i = 0; i < 5; i++) {
            thread[i] = new Thread(task);
            thread[i].setPriority(i + 1);
            thread[i].start();
        }

        for (int j = 0; j < 10; j++) {
            System.out.printf("Main: Logging threads\n");
            for (int i = 0; i < thread.length; i++) {
                System.out.printf("**********************\n");
                System.out.printf("Main: %d: Id: %d Name: %s: Priority: %d\n",
                        i,thread[i].getId(),thread[i].getName(),
                        thread[i].getPriority());
                System.out.printf("Main: Status: %s\n",thread[i].getState());
                System.out.printf("Main: Thread Group: %s\n",thread[i].getThreadGroup());
                System.out.printf("Main: Stack Trace: \n");
                for (int t=0; t<thread[i].getStackTrace().length; t++) {
                    System.out.printf("Main: %s\n",thread[i].getStackTrace()[t]);
                }
                System.out.printf("**********************\n");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.printf("+++++++++++++++");
    }
}
