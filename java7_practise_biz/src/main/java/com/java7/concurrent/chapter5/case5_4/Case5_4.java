package com.java7.concurrent.chapter5.case5_4;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by jackeyChen on 2016/5/12.
 */
public class Case5_4 {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FolderProcessor system = new FolderProcessor("C:\\windows", "log");
        FolderProcessor documents = new FolderProcessor("C:\\Documents And Settings", "log");
        FolderProcessor apps = new FolderProcessor("C:\\Program Files", "log");
        pool.execute(system);
        pool.execute(documents);
        pool.execute(apps);
        do{
            System.out.printf("****************************\n");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: steal Count: %d\n", pool.getStealCount());
            System.out.printf("****************************\n");
        } while((!system.isDone())||(!documents.isDone())||(!apps.isDone()));
        pool.shutdown();
        List<String> results;
        results = system.join();
        System.out.printf("System: %d files found.\n", results.size());
        results= apps.join();
        System.out.printf("Apps: %d files found.\n", results.size());
        results= documents.join();
        System.out.printf("Documents: %d files found.\n", results.size());
    }
}
