package com.wiley.beginningspring.ch7.domain;

/**
 * User: mertcaliskan
 * Date: 19/06/14
 */
public class SimpleUser {

    private String name;
    private String lastName;

    public SimpleUser() {
    }

    public SimpleUser(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
