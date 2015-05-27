package com.wiley.beginningspring.ch10;

/**
 * Created by mertcaliskan
 * on 18/08/14.
 */
public class User {

    private int id;
    private Long nationalId;
    private String name;
    private String phoneNumber;
    private int age;

    public User(int id, Long nationalId, String name, String phoneNumber, int age) {
        this.id = id;
        this.nationalId = nationalId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public Long getNationalId() {
        return nationalId;
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
                ", nationalId=" + nationalId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
