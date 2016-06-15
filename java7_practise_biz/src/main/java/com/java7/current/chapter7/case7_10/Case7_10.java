package com.java7.current.chapter7.case7_10;

import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/6/14.
 */
public class Case7_10 {
    public static void main(String[] args) throws Exception {
        MyPriorityTransferQueue<Event> buffer = new MyPriorityTransferQueue<Event>();
        Producer producer = new Producer(buffer);
        Thread producerThreads[] = new Thread[10];
        for(int i=0; i<producerThreads.length; i++) {
            producerThreads[i] = new Thread(producer);
            producerThreads[i].start();
        }

        //创建并运行一个 Consumer 任务。
        Consumer consumer=new Consumer(buffer);
        Thread consumerThread=new Thread(consumer);
        consumerThread.start();
        System.out.printf("Main: My Event has been transfered.\n");

        for(int i=0; i<producerThreads.length; i++) {
            try {
                producerThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.printf("Main: Buffer: Consumer count： %d\n", buffer.getWaitingConsumerCount());
        Event myEvent = new Event("Core Event 2", 0);
        buffer.transfer(myEvent);
        System.out.printf("Main: Buffer: Consumer count： %d\n", buffer.getWaitingConsumerCount());
        //使用join()方法等待消费者完结。
        consumerThread.join();
        System.out.printf("Main: End of the program");
    }
}
