package com.java7.current.util;

import java.io.PrintWriter;

/**
 * Created by dell on 2016/4/1.
 */
public class ThreadInfo {

    public static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : **********************************************");
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %d\n", state);
        pw.printf("Main : New State: %d\n", thread.getState());
        pw.printf("Main : **********************************************");
    }
}
