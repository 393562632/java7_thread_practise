package com.java7.concurrent.util;

/**
 * Created by dell on 2016/4/5.
 */
public class NumberUtil {
    public static Boolean isPrime(Long number ) {
        if(number < 2) {
            return true;
        }
        for(int i=2; i<number; i++) {
            if((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
