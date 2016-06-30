package com.java7.concurrent.chapter8.case8_4;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;


/**
 * Main class of the example. It creates all the elements for the
 * execution and writes information about the Fork/Join pool that
 * executes the task
 */
public class Case8_4 {

    public static void main(String[] args) throws Exception {
        ForkJoinPool pool = new ForkJoinPool();
        int array[] = new int[10000];
        Task task1 = new Task(array, 0, array.length);
        pool.execute(task1);
        while (!task1.isDone()) {
            showLog(pool);
            TimeUnit.SECONDS.sleep(1);
        }
        showLog(pool);
    }

    /**
     * getPoolSize(): 此方法返回 int 值，它是ForkJoinPool内部线程池的worker线程们的数量。
     * getParallelism(): 此方法返回池的并行的级别。
     * getActiveThreadCount(): 此方法返回当前执行任务的线程的数量。
     * getRunningThreadCount():此方法返回没有被任何同步机制阻塞的正在工作的线程。
     * getQueuedSubmissionCount(): 此方法返回已经提交给池还没有开始他们的执行的任务数。
     * getQueuedTaskCount(): 此方法返回已经提交给池已经开始他们的执行的任务数。
     * hasQueuedSubmissions(): 此方法返回 Boolean 值，表明这个池是否有queued任务还没有开始他们的执行。
     * getStealCount(): 此方法返回 long 值，worker 线程已经从另一个线程偷取到的时间数。
     * isTerminated(): 此方法返回 Boolean 值，表明 fork/join 池是否已经完成执行。
     *
     * @param pool
     */
    private static void showLog(ForkJoinPool pool) {
        System.out.printf("***********************");
        System.out.println("Main: Fork/Join pool: log\n");
        System.out.println("Main: Fork/Join pool: Parallelism:" + pool.getParallelism());
        System.out.println("Main: Fork/Join pool: Pool Size: " + pool.getPoolSize());
        System.out.println("Main: Fork/Join pool: Active Thread: " + pool.getActiveThreadCount());
        System.out.println("Main: Fork/Join pool: Running Thread Count: " + pool.getRunningThreadCount());
        System.out.println("Main: Fork/Join pool: Queued Submission: " + pool.getQueuedSubmissionCount());
        System.out.println("Main: Fork/Join pool: Queued tasks: " + pool.getQueuedSubmissionCount());
        System.out.println("Main: Fork/Join pool: Queued Submisions: " + pool.hasQueuedSubmissions());
        System.out.println("Main: Fork/Join pool: steal Count: " + pool.getStealCount());
        System.out.println("Main: Fork/Join pool: Terminated: " + pool.isTerminated());
        System.out.printf("***********************");
    }
}
