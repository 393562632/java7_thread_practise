package com.java7.current.chapter7.case7_8;

import java.util.Date;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by jackeyChen on 2016/6/8.
 */
public abstract class MyWorkTask extends ForkJoinTask<Void> {
    private String name;

    public MyWorkTask(String name) {
        this.name = name;
    }

    @Override
    public Void getRawResult() {
        return null;
    }

    @Override
    protected boolean exec() {
        Date startDate = new Date();
        compute();
        Date finishDate = new Date();
        long diff = finishDate.getTime() - startDate.getTime();
        System.out.printf("MyWorkTask: %s: %d Milliseconds to compute. \n", name, diff);
        return true;
    }

    protected abstract void compute();

    @Override
    protected void setRawResult(Void value) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
