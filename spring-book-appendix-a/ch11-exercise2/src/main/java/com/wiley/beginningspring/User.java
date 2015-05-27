package com.wiley.beginningspring;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by mertcaliskan
 * on 24/11/14.
 */
public class User {

    private int id;
    private String name;
    @JsonIgnore
    private String address;

    public User(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}