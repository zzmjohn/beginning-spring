package com.wiley.beginningspring.ch13;

import com.wiley.beginningspring.ch13.condition.EmailNotificationCondition;
import com.wiley.beginningspring.ch13.condition.SmsNotificationCondition;
import com.wiley.beginningspring.ch13.service.EmailNotificationService;
import com.wiley.beginningspring.ch13.service.NotificationService;
import com.wiley.beginningspring.ch13.service.SmsNotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mertcaliskan
 * on 22/10/14.
 */
@Configuration
@ComponentScan(basePackages = {"com.wiley.beginningspring.ch13"})
public class ApplicationConfig {

    @Bean(name="notificationService")
    @Conditional(EmailNotificationCondition.class)
    public NotificationService emailNotifier() {
        return new EmailNotificationService();
    }

    @Bean(name="notificationService")
    @Conditional(SmsNotificationCondition.class)
    public NotificationService smsNotifier() {
        return new SmsNotificationService();
    }
}
