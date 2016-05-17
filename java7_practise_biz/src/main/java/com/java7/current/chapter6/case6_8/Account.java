package com.java7.current.chapter6.case6_8;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lenovo on 2016/5/23.
 */
public class Account {
    private AtomicLong balance;

    public Account() {
        balance = new AtomicLong();
    }

    public long getBalance() {
        return balance.get();
    }

    public void setBalance(long balance) {
        this.balance.set(balance);
    }

    public void addAmount(long amount) {
        this.balance.getAndAdd(amount);
    }

    public void subtracAmount(long amount) {
        this.balance.getAndAdd(-amount);
    }
}
