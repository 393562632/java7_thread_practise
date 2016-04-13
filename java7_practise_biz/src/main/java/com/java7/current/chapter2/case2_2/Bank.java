package com.java7.current.chapter2.case2_2;

/**
 * Created by lenovo on 2016/4/13.
 */
public class Bank implements Runnable {
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    public void run() {
        for(int i=0; i<100; i++) {
            account.subtractAmount(1000);
        }
    }
}
