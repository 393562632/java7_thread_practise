package com.java7.current.chapter2.case2_6;

/**
 * Created by lenovo on 2016/4/14.
 */
public class Case2_6 {
    public static void main(String[] args){
        PricesInfo pricesInfo = new PricesInfo();
        Reader readers[] = new Reader[5];
        Thread threadRreader[] = new Thread[5];
        for(int i=0; i<5; i++) {
            readers[i] = new Reader(pricesInfo);
            threadRreader[i] = new Thread(readers[i]);
        }
        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);
        for(int i=0; i<5; i++ ) {
            threadRreader[i].start();
        }
        threadWriter.start();
    }
}
