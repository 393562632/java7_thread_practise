package com.java7.current.chapter1.case1_3;

import com.java7.current.chapter1.service.Calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dell on 2016/4/1.
 */
public class Case1_3 {

    public static void main(String[] args) {

        Thread threads[] = new Thread[10];
        Thread.State status[] = new Thread.State[10];
        boolean  finish = false;

        //设置优先级，初始化线程参数
        for(int i =0; i<10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if(i%2 == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread :" + i);
        }

        //创建一个文件输入流
        PrintWriter pw = null;
        try {
            FileWriter file = new FileWriter(".\\data\\log.txt");
            pw = new PrintWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //把十个文件的状态写入文件当中
        for(int i=0; i<10 ;i++) {
            pw.printf("Main : Status of Thread " + "i" + ":" + threads[i].getState());
            status[i] = threads[i].getState();
        }

        //开始执行10个线程
        for(int i = 0; i<10; i++) {
            threads[i].start();
        }

        //线程运行结束后，只要有一个线程执行完毕就把状态写入文件
        while(!finish) {

        }
    }


}
