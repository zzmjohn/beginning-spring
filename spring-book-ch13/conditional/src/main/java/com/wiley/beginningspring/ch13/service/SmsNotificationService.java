package com.wiley.beginningspring.ch13.service;

/**
 * Created by mertcaliskan
 * on 22/10/14.
 */
public class SmsNotificationService implements NotificationService {

    @Override
    public void notify(String username) {
        System.out.print("Notifying user: " + username + " with SMS.");
    }
}
