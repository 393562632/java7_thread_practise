package com.java7.concurrent.additional.case04;

import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by Administrator on 2016/6/24.
 */
public class Consumer implements Runnable {
    private LinkedTransferQueue<String> buffer;
    private String name;

    public Consumer(String name, LinkedTransferQueue<String> buffer) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i=0; i<10000; i++){
            try {
                buffer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Consumer: %s: Consumer done\n",name);
    }
}
