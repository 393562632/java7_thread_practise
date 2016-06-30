package com.java7.concurrent.chapter8.case8_5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 编写有效日志
 * Created by Administrator on 2016/6/21.
 */
public class Case8_5 {
    public static void main(String[] args) {
        Logger logger = MyLogger.getLogger("Core");
        // 使用 entering() 方法写日志信息表明主程序开始执行。
        logger.entering("Core", "main()", args);
        // 创建 Thread array 来保存5个线程。
        Thread threads[] = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            logger.log(Level.INFO, "Launching thread: " + i);
            Task task = new Task();
            threads[i] = new Thread(task);
            threads[i].start();
        }
        // 写日志信息表明你已经创建了线程。
        logger.log(Level.INFO, "Ten Threads created." + "Waiting for its finalization");

        // 使用 join() 方法等待5个线程的终结。在每个线程终结之后，写日志信息表明线程已经结束。
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
                logger.log(Level.INFO, "Thread has finished its execution", threads[i]);
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, "Exception", e);
            }
        }
        // 使用 exiting() 方法写一个日志信息表明主程序运行结束。
        logger.exiting("Core", "main()");
    }
}
