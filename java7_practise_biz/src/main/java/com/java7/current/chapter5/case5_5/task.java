package com.java7.current.chapter5.case5_5;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/5/16.
 */
public class Task extends RecursiveTask{
    public int arry[];
    private int start, end;

    public Task(int[] arry, int start, int end) {
        this.arry = arry;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Object compute() {
        System.out.printf("Task: Start from %d to %d \n ", start, end);
        if(end-start<10) {
            if((3>start)&&(3<end)) {
                throw new RuntimeException("Task: Start throws an" + "Excepton: Task from" + start + " to " + end);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            int mid = (end + start)/2;
            Task task1 = new Task(arry, start, mid);
            Task task2 = new Task(arry, mid, end);
            invokeAll(task1, task2);
        }
        System.out.printf("Task: End from %d to %d\n", start, end);
        return 0;
    }
}
