package com.java7.concurrent.chapter4.case4_5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lenovo on 2016/4/28.
 */
public class Case4_5 {
    public static void main(String[] args) {
        String username = "test";
        String password = "test";

        UserValidator ldapValidator = new UserValidator("LDAP");
        UserValidator dbValidator = new UserValidator("DAtaBase");
        TaskValidator ldapTask = new TaskValidator(ldapValidator, username, password);
        TaskValidator dbTask = new TaskValidator(dbValidator, username, password);
        List<TaskValidator> taskList = new ArrayList<TaskValidator>();
        taskList.add(ldapTask);
        taskList.add(dbTask);
        ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
        String result;
        try {
            result = executor.invokeAny(taskList);
            System.out.printf("Main: Result %s\n", result);
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            e.printStackTrace();
        };
        executor.shutdown();
        System.out.printf("Main: End of Exception.\n");
    }
}
