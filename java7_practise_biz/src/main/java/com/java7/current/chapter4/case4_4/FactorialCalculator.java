package com.java7.current.chapter4.case4_4;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/28.
 */
public class FactorialCalculator implements Callable<Integer>{
    private Integer number;

    public FactorialCalculator(Integer integer) {
        this.number = integer;
    }

    public Integer call() throws Exception {
        int result = 1;
        if((number == 0)||( number == 1 )) {
            number = 1;
        }else {
            for(int i=2; i<=number; i++) {
                result *= i;
                TimeUnit.SECONDS.sleep(1);
            }
        }
        System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);
        return result;
    }
}
