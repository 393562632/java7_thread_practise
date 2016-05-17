package com.java7.current.chapter7.case7_7;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * Created by jackeyChen on 2016/6/7.
 */
public class MyRecursiveTask extends RecursiveTask<Integer> {

    private int array[];
    private int start, end;

    public MyRecursiveTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        MyWorkerThread thread = (MyWorkerThread) Thread.currentThread();
        thread.addTask();
        if (end - start < 10) {
            System.out.println(thread);
            int counter = 0;
            while (start < end) {
                start++;
                counter++;
            }
            return counter;
        } else {
            int mid = (start + end) / 2;
            MyRecursiveTask thread1 = new MyRecursiveTask(array, start, mid);
            MyRecursiveTask thread2 = new MyRecursiveTask(array, mid, end);
            invokeAll(thread1, thread2);
            return addResults(thread1, thread2);
        }
    }

    private Integer addResults(MyRecursiveTask task1, MyRecursiveTask task2) {
        int value;
        try {
            value = ((Integer) task1.get()).intValue() + ((Integer) task2.get()).intValue();
        } catch (InterruptedException var5) {
            var5.printStackTrace();
            value = 0;
        } catch (ExecutionException var6) {
            var6.printStackTrace();
            value = 0;
        }
        return new Integer(value);
    }
}
