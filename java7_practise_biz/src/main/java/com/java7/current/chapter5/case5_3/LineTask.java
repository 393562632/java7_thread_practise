package com.java7.current.chapter5.case5_3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * Created by jackeyChen on 2016/5/10.
 */
public class LineTask extends RecursiveTask<Integer>{
    private static final long serialVersionUID = -5314580166686346302L;
    private String line[];
    private int start, end;
    private String word;

    public LineTask(String line[],  int start, int end, String word) {
        this.line = line;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected Integer compute() {
        Integer result = null;
        if(end - start < 100) {
            result = count(line, start, end, word);
        } else {
            int mid = (start+end)/2;
            LineTask task1 = new LineTask(line, start, mid, word);
            LineTask task2 = new LineTask(line, mid, end, word);
            invokeAll(task1, task2);
            try {
                result = groupResult(task1.get(), task2.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Integer count (String[] line, int start, int end, String word) {
        int counter;
        counter = 0;
        for(int i=start; i<end; i++) {
            if(line[i].equals(word)) {
                counter++;
            }
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return counter;
    }

    private Integer groupResult(Integer number1, Integer number2) {
        Integer result;
        result = number1 + number2;
        return result;
    }
 }
