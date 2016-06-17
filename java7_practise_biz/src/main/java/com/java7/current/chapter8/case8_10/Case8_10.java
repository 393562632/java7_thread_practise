package com.java7.current.chapter8.case8_10;

import edu.umd.cs.mtc.TestFramework;

/**
 * Created by Administrator on 2016/6/22.
 */
public class Case8_10 {
    public static void main(String[] args) throws Throwable {
        //创建 ProducerConsumerTest 对象，名为 test。
        ProducerConsumerTest test=new ProducerConsumerTest();
        //使用 TestFramework 类的 runOnce()方法来执行测试。
        System.out.printf("Main: Starting the test\n");
        TestFramework.runOnce(test);
        System.out.printf("Main: The test has finished\n");
    }
}
