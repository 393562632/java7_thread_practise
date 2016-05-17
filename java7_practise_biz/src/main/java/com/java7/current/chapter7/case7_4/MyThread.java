package com.java7.current.chapter7.case7_4;

import java.util.Date;

/**
 * Created by jackeyChen on 2016/5/27.
 */
public class MyThread extends Thread {
    private Date creationDate;
    private Date startDate;
    private Date finishDate;

    public MyThread(Runnable target, String name) {
        super(target, name);
        setCreationDate();
    }

    @Override
    public void run() {
        setSatrtDate();
        super.run();
        setFInishDate();
    }

    public void setCreationDate() {
        creationDate = new Date();
    }

    public void setSatrtDate() {
        startDate = new Date();
    }

    public void setFInishDate() {
        finishDate = new Date();
    }

    public long getExecutionTime() {
        return finishDate.getTime() - startDate.getTime();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getName());
        buffer.append(":");
        buffer.append("Creation Date: ");
        buffer.append(creationDate);
        buffer.append(": Running time: ");
        buffer.append(getExecutionTime());
        buffer.append("Milliseconds. ");
        return buffer.toString();
    }
}
