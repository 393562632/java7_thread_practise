package com.java7.current.chapter3.case3_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by jackeyChen on 2016/4/21.
 */
public class Searcher implements Runnable {
    private int firstRow;
    private int lastRow;
    private MatrixMock mock;
    private Results result;
    private int number;
    private final CyclicBarrier barrier;

    public Searcher(int firstRow, int lastRow, MatrixMock mock, Results result, int number, CyclicBarrier barrier) {
        this.barrier = barrier;
        this.number = number;
        this.result = result;
        this.mock = mock;
        this.lastRow = lastRow;
        this.firstRow = firstRow;
    }

    public void run() {
        int counter;
        System.out.printf("%s: Processing lines from %d to %d\n", Thread.currentThread().getName(), firstRow, lastRow);
        for(int i=firstRow; i<lastRow; i++) {
            int row[] = mock.getRow(i);
            counter = 0;
            for(int j = 0; j<row.length; j++) {
                if(row[j] == number) {
                    counter++;
                }
            }
            result.setData(i,counter);
        }
        System.out.printf("%s: Lines processed.\n", Thread.currentThread().getName());
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
