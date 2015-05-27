package com.wiley.beginningspring.ch13.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by mertcaliskan
 * on 22/10/14.
 */
public class SmsNotificationCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty("notificationSystem").contains("sms");
    }
}