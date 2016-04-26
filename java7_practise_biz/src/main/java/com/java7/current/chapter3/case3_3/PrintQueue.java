package com.java7.current.chapter3.case3_3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lenovo on 2016/4/18.
 */
public class PrintQueue {
    private boolean freePrinters[];
    private Lock lockPrinters;
    private final Semaphore semaphore;

    public PrintQueue() {

        this.semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        for(int i = 0; i<freePrinters.length; i++) {
            freePrinters[i] = true;
        }
        lockPrinters = new ReentrantLock();
    }

    public void PrintJob(Object object) {

        try {
            semaphore.acquire();
            int assignedPrinter = getPrinter();
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n",
                    Thread.currentThread().getName(),assignedPrinter, duration );
            TimeUnit.SECONDS.sleep(duration);
            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public int getPrinter() {

        int ret  = -1;
        try {
            lockPrinters.lock();
            for(int i = 0; i<freePrinters.length; i++) {
                if(freePrinters[i] == true) {
                    ret = i;
                    freePrinters[i] = true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
        return ret;
    }

}
