package com.java7.concurrent.chapter5.case5_6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by jackeyChen on 2016/5/16.
 */
public class TaskManager {
    private List<ForkJoinTask<Integer>> tasks;

    public TaskManager(List<ForkJoinTask<Integer>> tasks) {
        this.tasks = tasks;
    }

    public TaskManager() {
        tasks = new ArrayList();
    }

    public void addTask(ForkJoinTask<Integer> task) {
        tasks.add(task);
    }

    public void cancelTasks(ForkJoinTask<Integer> cancelTask) {
        for(ForkJoinTask<Integer> task: tasks) {
            if(task!=cancelTask) {
                task.cancel(true);
                ((SearchNumberTask) task).writeCancelMessage();
            }
        }
    }
}
