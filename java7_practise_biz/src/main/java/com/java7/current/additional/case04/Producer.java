package com.java7.current.additional.case04;

import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by Administrator on 2016/6/24.
 */
public class Producer implements Runnable {
    private LinkedTransferQueue<String> buffer;
    private String name;

    public Producer(String name, LinkedTransferQueue<String> buffer)
    {
        this.name=name;
        this.buffer=buffer;
    }

    @Override
    public void run() {
        for (int i=0; i<10000; i++) {
            buffer.put(name+": Element "+i);
        }
        System.out.printf("Producer: %s: Producer done\n",name);
    }
}
