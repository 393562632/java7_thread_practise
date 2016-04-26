package com.java7.current.chapter4.case4_11;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/5/3.
 */
public class ReportProcessor implements Runnable {
    private CompletionService<String> service;
    private Boolean end;

    public ReportProcessor(CompletionService<String> service) {
        this.service = service;
        this.end = false;
    }

    public void run() {
        while(!end) {
            try {
                Future<String> result = service.poll(20, TimeUnit.SECONDS);
                if(result != null) {
                    String report = result.get();
                    System.out.printf("ReportReceiver: Report Received:%s\n", report);
                }
            } catch (InterruptedException | ExecutionException e ) {
                e.printStackTrace();
            }
        }
        System.out.printf("ReportSender: End\n");
    }

    public void setEnd(Boolean end) {
        this.end = end;
    }
}
