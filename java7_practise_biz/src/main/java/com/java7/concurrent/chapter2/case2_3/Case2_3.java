package com.java7.concurrent.chapter2.case2_3;

/**
 * Created by lenovo on 2016/4/13.
 */
public class Case2_3 {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
        Thread thread1 = new Thread(ticketOffice1, "ticketOffice1");
        TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
        Thread thread2 = new Thread(ticketOffice2, "ticketOffice2");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Rom1 Vacanses: %d\n",cinema.getVacanciesCinemal1());
        System.out.printf("Rom2 Vacanses: %d\n",cinema.getVacanciesCinemal2());
    }
}
