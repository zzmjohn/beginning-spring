package com.wiley.beginningspring.ch7.domain;


import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    @Size(min=3, max=20)
    String username;
    @Email
    String email;
    @CreditCardNumber
    String ccNumber;
    @Pattern(regexp = "^[a-zA-Z]\\w{3,14}$")
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}