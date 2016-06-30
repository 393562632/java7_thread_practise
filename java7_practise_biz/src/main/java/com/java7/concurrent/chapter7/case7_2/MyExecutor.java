package com.java7.concurrent.chapter7.case7_2;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by jackeyChen on 2016/5/30.
 */
public class MyExecutor extends ThreadPoolExecutor {
    private ConcurrentHashMap<String, Date> startTimes;

    public MyExecutor(int corePoolSize,
                      int maximumPoolSize,
                      long keepAliveTime,
                      TimeUnit unit,
                      BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        startTimes=new ConcurrentHashMap<String, Date>();
    }

    @Override
    public void shutdown() {
        System.out.printf("MyExecutor: Going to shutdown.\n");
        System.out.printf("MyExecutor: Executed tasks: %d\n",getCompletedTaskCount());
        System.out.printf("MyExecutor: Running tasks: %d\n",getActiveCount());
        System.out.printf("MyExecutor: Pending tasks: %d\n",getQueue().size());
        super.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        System.out.printf("MyExecutor: Going to immediately shutdown.\n");
        System.out.printf("MyExecutor: Executed tasks: %d\n",getCompletedTaskCount());
        System.out.printf("MyExecutor: Running tasks: %d\n",getActiveCount());
        System.out.printf("MyExecutor: Pending tasks: %d\n",getQueue().size());
        return super.shutdownNow();
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        Future<?> result = (Future<?>)r;
        try {
            System.out.printf("**************************\n");
            System.out.printf("MyExecutor: A task is finishing.\n");
            System.out.printf("MyExecutor: Result: %s\n",result.get());
            Date startDate=startTimes.remove(String.valueOf(r.hashCode()));
            Date finishDate=new Date();
            long diff=finishDate.getTime()-startDate.getTime();
            System.out.printf("MyExecutor: Duration: %d\n",diff);
            System.out.printf("**************************\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.printf("MyExecutor: A task is beginning: %s : %s\n",t.getName(),r.hashCode());
                startTimes.put(String.valueOf(r.hashCode()), new Date());
    }
}