package com.java7.current.chapter6.case6_8;

/**
 * Created by jackeyChen on 2016/5/23.
 */
public class Case6_8 {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);
        Company company = new Company(account);
        Thread companyThread = new Thread(company);
        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);
        System.out.printf("Account: Initial Balance: %d\n", account.getBalance());
        companyThread.start();
        bankThread.start();
        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account: Final Balancce; %d\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
