package com.java7.current.chapter7.case7_2;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by jackeyChen on 2016/5/30.
 */

public class SleepTwoSecondTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return new Date().toString();
    }
}
