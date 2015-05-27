package com.wiley.beginningspring.ch13.bean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by mertcaliskan
 * on 22/10/14.
 */
@Component
@Order(value = 2)
public class StudentTwo extends Person {
}
