package com.java7.current.chapter7.case7_10;

/**
 * Created by jackeyChen on 2016/6/14.
 */
public class  Producer implements Runnable {

    private MyPriorityTransferQueue<Event> buffer;

    public Producer(MyPriorityTransferQueue<Event> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            Event event = new Event(Thread.currentThread().getName(), i);
            buffer.put(event);
        }
    }
}
