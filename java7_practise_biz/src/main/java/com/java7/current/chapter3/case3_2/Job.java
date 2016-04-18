package com.java7.current.chapter3.case3_2;

/**
 * Created by lenovo on 2016/4/18.
 */
public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    public void run() {
        System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
        printQueue.PrintJob(new Object());
        System.out.printf("%s the document has benn printed\n", Thread.currentThread().getName());
    }
}
