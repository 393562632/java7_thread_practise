package com.java7.concurrent.chapter8.case8_5;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2016/6/21.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        //12. 首先，声明一个 Logger 对象，名为 logger。使用 MyLogger 类的 getLogger() 方法传递这个类的名字为参数来初始它。
        Logger logger = MyLogger.getLogger(this.getClass().getName());
        logger.entering(Thread.currentThread().getName(), "run()");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //14.使用 exiting() 方法写日志信息表明执行结束
        logger.exiting(Thread.currentThread().getName(), "run()", Thread.currentThread());
    }
}
