package com.java7.current.chapter4.case4_6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by lenovo on 2016/4/28.
 */
public class Case4_6 {
    public static void main(String[] args) {
        ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
        List<Task> taskList = new ArrayList<Task>();
        for(int i=0; i<3; i++) {
            Task task = new Task(i + "");
            taskList.add(task);
        }
        List<Future<Result>> resultList = null;
        try {
            resultList = executor.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("Main: Print the result ");
        for(int i =0; i<resultList.size(); i++) {
            Future<Result> future = resultList.get(i);
            try {
                Result result = future.get();
                System.out.printf(result.getName() + "：" + result.getValue() +"\n");
            } catch (InterruptedException e) {

            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
