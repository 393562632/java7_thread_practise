package com.java7.current.chapter4.case4_11;


import java.util.concurrent.CompletionService;

/**
 * Created by lenovo on 2016/5/3.
 */
public class ReportRequest implements Runnable {
    private String name;
    private CompletionService<String> service;

    public ReportRequest(String name, CompletionService<String> service) {
        this.name = name;
        this.service = service;
    }

    public void run() {
        ReportGenerator reportGenerator=new ReportGenerator(name,"Report");
        service.submit(reportGenerator);
    }
}
