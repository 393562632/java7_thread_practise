package com.java7.current.chapter2.case2_3;

/**
 * Created by lenovo on 2016/4/13.
 */
public class Cinema {
    private long vacanciesCinemal1;
    private long vacanciesCinemal2;

    private final Object controlCinemal1, ControlCinemal2;

    public Cinema() {
        this.vacanciesCinemal1 = 20;
        this.vacanciesCinemal2 = 20;
        this.controlCinemal1 = new Object();
        this.ControlCinemal2 = new Object();
    }

    //买票的方法
    public boolean sellTicket1 (int number) {
        synchronized (controlCinemal1) {
            if(number<vacanciesCinemal1){
                vacanciesCinemal1-=number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean sellTicket2 (int number) {
        synchronized (ControlCinemal2) {
            if(number<vacanciesCinemal2){
                vacanciesCinemal2-=number;
                return true;
            } else {
                return false;
            }
        }
    }

    //退票的方法
    public boolean returnTicket1(int number) {
        synchronized (controlCinemal1) {
            vacanciesCinemal1+=number;
            return true;
        }
    }

    public boolean returnTicket2(int number) {
        synchronized (ControlCinemal2) {
            vacanciesCinemal2+=number;
            return true;
        }
    }

    //返回相应电影票的票数
    public long getVacanciesCinemal1() {
        return vacanciesCinemal1;
    }

    public long getVacanciesCinemal2() {
        return vacanciesCinemal2;
    }
}
