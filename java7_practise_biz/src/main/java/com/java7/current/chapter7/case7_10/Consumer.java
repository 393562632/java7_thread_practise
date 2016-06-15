package com.java7.current.chapter7.case7_10;

/**
 * Created by jackeyChen on 2016/6/14.
 */
public class Consumer implements Runnable {

    private MyPriorityTransferQueue buffer;

    public Consumer(MyPriorityTransferQueue buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i=0; i<1001; i++) {
            try {
                Event value = (Event) buffer.take();
                System.out.printf("Consumer: %s : %d  i = %d\n", value.getThread(), value.getPriority(), i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
