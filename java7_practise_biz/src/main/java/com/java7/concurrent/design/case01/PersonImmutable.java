package com.java7.concurrent.design.case01;

/**
 *  Created by Administrator on 2016/6/30.
 *  The class is marked as final.
 *  The attributes are marked as final and private.
 *  The value of the attributes can only be established in the constructor of the class.
 *  The rest of its methods returns the value of an attribute, but don't modify them.
 */
public final class PersonImmutable {
    final private String firstName;
    final private String lastName;

    public PersonImmutable(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
