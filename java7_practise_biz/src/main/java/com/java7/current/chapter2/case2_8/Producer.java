package com.java7.current.chapter2.case2_8;

/**
 * Created by lenovo on 2016/4/15.
 */
public class Producer implements Runnable {
    private FileMock mock;
    private Buffer buffer;

    public Producer(FileMock mock, Buffer buffer) {
        this.mock = mock;
        this.buffer = buffer;
    }

    public void run() {
        buffer.setPendingLines(true);
        while(mock.hasMoreLines()) {
            String line = mock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
