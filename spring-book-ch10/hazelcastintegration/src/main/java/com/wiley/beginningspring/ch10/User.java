package com.wiley.beginningspring.ch10;

import java.io.Serializable;

/**
 * Created by mertcaliskan
 * on 18/08/14.
 */
public class User implements Serializable {

    private int id;
    private String name;
    private String phoneNumber;
    private int age;

    public User() {
    }

    public User(int id, String name, String phoneNumber, int age) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
