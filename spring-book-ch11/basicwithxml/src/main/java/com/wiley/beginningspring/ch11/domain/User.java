package com.wiley.beginningspring.ch11.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by mertcaliskan
 * on 22/09/14.
 */
@XmlRootElement
public class User {

    @XmlElement
    private int id;
    @XmlElement
    private String name;

    public User() {}

    public User(int id, String name) {
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
