package com.java7.concurrent.additional.case02;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2016/6/22.
 */
public class Case02 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        FileSearch system = new FileSearch("C:\\Windows", "log");
        FileSearch apps = new FileSearch("C:\\Program Files", "log");
        FileSearch documents = new FileSearch("C:\\Documents And Settings", "log");
        Task systemTask = new Task(system, null);
        Task appsTask = new Task(apps, null);
        Task documentsTask = new Task(documents, null);
        FutureTask systemTaskFuture = (FutureTask) executor.submit(systemTask);
        FutureTask appsTaskFuture = (FutureTask) executor.submit(appsTask);
        FutureTask documentsTaskFuture = (FutureTask) executor.submit(documentsTask);
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.printf("Main: System Task: Number of Results: %d%n", systemTask.get().size());
            System.out.printf("Main: App Task: Number of Results: %d%n", appsTask.get().size());
            System.out.printf("Main: Documents Task: Number of Results: %d%n", documentsTask.get().size());
            System.out.printf("use Future get the result %s %n", systemTaskFuture.get());
            System.out.printf("use Future get the result %s %n", appsTaskFuture.get());
            System.out.printf("use Future get the result %s %n", documentsTaskFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
