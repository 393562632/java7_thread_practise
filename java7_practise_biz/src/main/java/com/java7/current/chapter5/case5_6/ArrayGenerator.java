package com.java7.current.chapter5.case5_6;

import java.util.Random;

/**
 * Created by lenovo on 2016/5/16.
 */
public class ArrayGenerator {
    public int[] generateArrary(int size) {
        int arrary[] = new int[size];
        Random random = new Random();
        for(int i=0; i<size; i++) {
            arrary[i] = random.nextInt(10);
        }
        return arrary;
    }
}
