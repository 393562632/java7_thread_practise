package com.java7.concurrent.util;

import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2016/4/1.
 */
public class ThreadInfo {

    public static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : **********************************************\n");
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : **********************************************\n");
    }

    public static void waitFinish(ThreadGroup threadGroup) {
        while(threadGroup.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
