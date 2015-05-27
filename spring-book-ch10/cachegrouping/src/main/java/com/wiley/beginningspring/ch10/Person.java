package com.wiley.beginningspring.ch10;

/**
 * Created by mertcaliskan
 * on 21/08/14.
 */
public abstract class Person {

    private int id;
    private String name;

    protected Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
