package com.java7.current.chapter3.case3_8;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by lenovo on 2016/4/26.
 */
public class Case3_8 {
    public static void main(String[] args) {
        List<String> buffer1 = new ArrayList<String>();
        List<String> buffer2 = new ArrayList<String>();
        Exchanger<List<String>> exchanger = new Exchanger<List<String>>();
        Producer producer = new Producer(exchanger, buffer1);
        Consumer consumer = new Consumer(exchanger, buffer2);
        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);
        threadConsumer.start();
        threadProducer.start();
    }
}
