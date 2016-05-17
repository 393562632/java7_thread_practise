package com.java7.current.chapter6.case6_3;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/5/17.
 */
public class Case6_3 {
    public static void main(String[] args) throws Exception {
        LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);
        Client client = new Client(list);
        Thread thread = new Thread(client);
        thread.start();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                String request = list.take();
                System.out.printf("Main: Request: %s at %s. size: %d\n", request, new Date(), list.size());
            }
            TimeUnit.MILLISECONDS.sleep(30);
        }
        System.out.printf("Main: End of the program\n");
    }
}
