package com.wiley.beginningspring;

import java.io.Serializable;

/**
 * Created by mertcaliskan
 * on 23/11/14.
 */
public class Course implements Serializable {

    private int id;
    private String name;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
