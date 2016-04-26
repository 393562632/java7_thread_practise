package com.java7.current.chapter4.case4_3;


/**
 * Created by jackeyChen on 2016/4/26.
 */
public class Case4_3 {
    public static void main(String[] args) {
        Server server = new Server();
        for(int i=0; i<100; i++) {
            Task task = new Task("Task" + i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
