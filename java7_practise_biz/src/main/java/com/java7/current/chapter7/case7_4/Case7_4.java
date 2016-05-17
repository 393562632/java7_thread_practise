package com.java7.current.chapter7.case7_4;

/**
 * Created by jackeyChen on 2016/5/27.
 */
public class Case7_4 {
    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory("MyThreadFactory");
        MyTask task = new MyTask();
        Thread thread = myThreadFactory.newThread(task);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Thread information.\n");
        System.out.printf("%s\n", thread);
        System.out.printf("Main: End of the Example.\n");
    }
}
