package com.wiley.beginningspring.ch7.exception;

/**
 * User: mertcaliskan
 * Date: 12/06/14
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException(String name) {
        super("User not found with name: " + name);
    }
}