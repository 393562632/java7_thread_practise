package com.java7.concurrent.chapter3.case3_8;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by lenovo on 2016/4/26.
 */
public class Consumer implements Runnable{
    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public Consumer(Exchanger<List<String>> exchanger, List<String> buffer) {
        this.exchanger = exchanger;
        this.buffer = buffer;
    }

    public void run() {
        int cycle = 1;
        for(int i=0; i<10; i++) {
            System.out.printf("Consumer: cycle %d\n", cycle);
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumer:" + buffer.size());
            for(int j=0; j<10; j++) {
                String message = buffer.get(0);
                System.out.println("Consumer:" + message);
                buffer.remove(0);
            }
            cycle++;
        }
    }
}
