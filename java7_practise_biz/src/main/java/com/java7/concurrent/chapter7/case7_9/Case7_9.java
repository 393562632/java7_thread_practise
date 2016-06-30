package com.java7.concurrent.chapter7.case7_9;


import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/6/8.
 */
public class Case7_9 {
    public static void main(String[] args) {
      /*
		 * Create a new MyLock object
		 */
        MyLock lock=new MyLock();

		/*
		 * Create and run ten task objects
		 */
        for (int i=0; i<10; i++){
            Task task=new Task("Task-"+i,lock);
            Thread thread=new Thread(task);
            thread.start();
        }

		/*
		 * The main thread also tries to get the lock
		 */
        boolean value;
        do {
            try {
                value=lock.tryLock(1,TimeUnit.SECONDS);
                if (!value) {
                    System.out.printf("Main: Trying to get the Lock\n");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                value=false;
            }
        } while (!value);

		/*
		 * The main thread release the lock
		 */
        System.out.printf("Main: Got the lock\n");
        lock.unlock();

		/*
		 * Write a message in the console indicating the end of the program
		 */
        System.out.printf("Main: End of the program\n");
    }
}
