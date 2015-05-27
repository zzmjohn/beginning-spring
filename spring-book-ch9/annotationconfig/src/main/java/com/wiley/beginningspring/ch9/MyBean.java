package com.wiley.beginningspring.ch9;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by mertcaliskan
 * on 11/08/14.
 */
@Component
public class MyBean {

    @Value("#{systemProperties['user.language']}")
    private String message;

    public String getMessage() {
        return message;
    }
}
