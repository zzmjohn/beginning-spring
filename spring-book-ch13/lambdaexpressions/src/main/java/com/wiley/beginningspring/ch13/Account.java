package com.wiley.beginningspring.ch13;

import java.sql.Timestamp;
import java.util.Date;

public class Account {

    private long id;
    private String ownerName;
    private double balance;
    private Date accessTime;
    private boolean locked;

    public Account(long id, String owner_name, double balance, Timestamp access_time, boolean locked) {
        this.id = id;
        this.ownerName = owner_name;
        this.balance = balance;
        this.accessTime = access_time;
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                ", accessTime=" + accessTime +
                ", locked=" + locked +
                '}';
    }
}
