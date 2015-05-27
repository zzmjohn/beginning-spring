package com.wiley.beginningspring.ch6;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
	@GeneratedValue
	private long id;
    private String ownerName;
    private double balance;
    private Date accessTime;
    private boolean locked;
    private byte[] ownerPhoto;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public byte[] getOwnerPhoto() {
		return ownerPhoto;
	}
	public void setOwnerPhoto(byte[] ownerPhoto) {
		this.ownerPhoto = ownerPhoto;
	}
    
    //getters & setters...
}