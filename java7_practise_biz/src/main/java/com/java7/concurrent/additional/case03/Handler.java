package com.java7.concurrent.additional.case03;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/24.
 */
public class Handler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("Handler: Thread %s has thrown an Exception.\n",t.getName());
        System.out.printf("%s\n",e);
        System.exit(-1);
    }
}
