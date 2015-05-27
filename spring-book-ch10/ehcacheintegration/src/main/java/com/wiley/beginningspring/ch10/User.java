package com.wiley.beginningspring.ch10;

/**
 * Created by mertcaliskan
 * on 18/08/14.
 */
public class User {

    private int id;
    private String name;
    private String phoneNumber;
    private int age;

    public User(int id, String name, String phoneNumber, int age) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public int getId() {
        return id;
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
