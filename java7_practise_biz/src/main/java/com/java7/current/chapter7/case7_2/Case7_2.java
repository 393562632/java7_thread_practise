package com.java7.current.chapter7.case7_2;

import com.java7.current.chapter7.case7_2.SleepTwoSecondTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/5/30.
 */
public class Case7_2 {
    public static void main(String[] args) {
        MyExecutor myExecutor=new MyExecutor(2, 4, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
        List<Future<String>> results=new ArrayList<Future<String>>();
        for (int i=0; i<10; i++) {
            SleepTwoSecondTask task=new SleepTwoSecondTask();
            Future<String> result=myExecutor.submit(task);
            results.add(result);
        }

        for (int i=0; i<5; i++) {
            try {
                String result = results.get(i).get();
                System.out.printf("Main: Result for Task %d : %s\n", i, result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        myExecutor.shutdown();

        for (int i=5; i<10; i++){
            try {
                String result=results.get(i).get();
                System.out.printf("Main: Result for Task %d : %s\n",i,result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        try {
            myExecutor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: End of the program.\n");
    }
}
