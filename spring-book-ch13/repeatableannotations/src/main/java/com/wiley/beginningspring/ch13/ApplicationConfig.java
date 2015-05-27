package com.wiley.beginningspring.ch13;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by mertcaliskan
 * on 22/10/14.
 */
@Configuration
@ComponentScan(basePackages = {"com.wiley.beginningspring.ch13"})
@EnableScheduling
public class ApplicationConfig {
}
