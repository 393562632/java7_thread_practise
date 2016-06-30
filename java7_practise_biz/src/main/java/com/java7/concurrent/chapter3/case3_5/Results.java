package com.java7.concurrent.chapter3.case3_5;

/**
 * Created by lenovo on 2016/4/21.
 */
public class Results {
    private int data[];

    public Results(int size) {
        data = new int[size];
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getdata() {
        return data;
    }
}
