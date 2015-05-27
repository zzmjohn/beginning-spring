package com.wiley.beginningspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by mertcaliskan
 * on 23/11/14.
 */
@Component
public class MyBean {

    @Value("#{systemProperties['user.country']}")
    private String message;

    public String getMessage() {
        return message;
    }
}
