package com.wiley.beginningspring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by mertcaliskan
 * on 23/11/14.
 */
@Configuration
@ComponentScan(basePackages = {"com.wiley.beginningspring"})
@EnableAspectJAutoProxy
public class ApplicationConfig {
}
