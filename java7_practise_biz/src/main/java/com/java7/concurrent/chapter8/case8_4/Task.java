package com.java7.concurrent.chapter8.case8_4;

import java.util.concurrent.RecursiveAction;

/**
 * Created by Administrator on 2016/6/20.
 */
public class Task extends RecursiveAction {

    private int[] arrary;
    private int start;
    private int end;

    public Task(int[] arrary, int start, int end) {
        this.arrary = arrary;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if(end - start >100) {
            int mid = (start + end) / 2;
            Task task1 = new Task(arrary, start, mid);
            Task task2 = new Task(arrary, mid, end);
            task1.fork();
            task2.fork();
            task1.join();
            task2.join();
        } else {
            for(int i = start; i<end; i++) {
                arrary[i]++;
                try{
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
