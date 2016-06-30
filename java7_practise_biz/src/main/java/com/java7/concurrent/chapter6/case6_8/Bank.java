package com.java7.concurrent.chapter6.case6_8;

/**
 * Created by lenovo on 2016/5/23.
 */
public class Bank implements Runnable {
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.subtracAmount(1000);
        }
    }
}
