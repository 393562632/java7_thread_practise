package com.java7.concurrent.additional.case02;

import java.util.List;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2016/6/23.
 */
public class Task extends FutureTask<List<String>> {
    private FileSearch fileSearch;

    public Task(Runnable runnable, List<String> result) {
        super(runnable, result);
        this.fileSearch = (FileSearch) runnable;
    }

    protected void set(List<String> v) {
        if (v == null) {
            v = fileSearch.getResults();
        }
        super.set(v);
    }
}
