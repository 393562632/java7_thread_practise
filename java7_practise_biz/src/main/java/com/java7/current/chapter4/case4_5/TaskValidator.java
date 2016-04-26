package com.java7.current.chapter4.case4_5;

import java.util.concurrent.Callable;

/**
 * Created by lenovo on 2016/4/28.
 */
public class TaskValidator implements Callable<String> {
    private UserValidator validator;
    private String user;
    private String password;

    public TaskValidator(UserValidator validator, String user, String password) {
        this.validator = validator;
        this.user = user;
        this.password = password;
    }

    public String call() throws Exception {
        if(!validator.validate(user, password)) {
            System.out.printf("%s: The user has not been found\n", validator.getName() );
            throw new Exception("Error validator user.");
        }
        System.out.printf("%s: The user has been found\n", validator.getName());
        return validator.getName();
    }
}
