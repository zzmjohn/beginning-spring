package com.wiley.beginningspring.ch9.domain;

/**
 * Created by mertcaliskan
 * on 14/08/14.
 */
public class Worker {

    private String name;
    private Country birthPlace;

    public Worker(String name, Country birthPlace) {
        this.name = name;
        this.birthPlace = birthPlace;
    }

    public String getName() {
        return name;
    }

    public Country getBirthPlace() {
        return birthPlace;
    }
}
