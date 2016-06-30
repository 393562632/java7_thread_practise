package com.java7.concurrent.chapter7.case7_8;


/**
 * Created by jackeyChen on 2016/6/8.
 */
public class Task extends MyWorkTask {
    private int[] array;
    int start;
    int end;

    public Task(String name, int[] array, int start, int end) {
        super(name);
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public Task(String name) {
        super(name);
    }

    @Override
    protected void compute() {
        if (end - start > 100) {
            int mid = (start + end) / 2;
            Task task1 = new Task(this.getName() + "1", array, start, mid);
            Task task2 = new Task(this.getName() + "2", array, mid, end);
            invokeAll(task1, task2);
        } else {
            for (int i = start; i < end; i++) {
                array[i]++;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


