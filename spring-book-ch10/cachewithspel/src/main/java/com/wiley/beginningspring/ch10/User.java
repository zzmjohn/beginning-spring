package com.wiley.beginningspring.ch10;

/**
 * Created by mertcaliskan
 * on 18/08/14.
 */
public class User {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id +", name='" + name + '\'' + '}';
    }
}
