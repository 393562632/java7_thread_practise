package com.java7.current.chapter7.case7_3;

import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/5/27.
 */
public class MyPriorityTask implements Runnable, Comparable<MyPriorityTask> {
    private int priority;
    private String name;

    public MyPriorityTask(String name, int priority) {
        this.priority = priority;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(toString());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(MyPriorityTask o) {
        if(this.priority < o.getPriority()) {
            return 1;
        } else if (this.priority > o.getPriority()) {
            return -1;
        }
        return 0;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyPriorityTask{" +
                "priority=" + priority +
                ", name=" + name +
                '}';
    }
}
