package com.java7.current.chapter7.case7_6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/5/31.
 */
public class Case7_6 {
    public static void main(String[] args) throws Exception {
        MyScheduledThreadPoolExecutor executor = new MyScheduledThreadPoolExecutor(2);
        Task task = new Task();
//        System.out.printf("Main： %s\n", new Date());
//        executor.schedule(task, 1, TimeUnit.SECONDS);
//        TimeUnit.SECONDS.sleep(3);
//        task = new Task();
        System.out.printf("Main: %s\n", new Date());
        executor.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(10);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}