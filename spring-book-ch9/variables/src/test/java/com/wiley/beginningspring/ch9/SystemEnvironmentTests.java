package com.wiley.beginningspring.ch9;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Map;

/**
 * Created by mertcaliskan
 * on 14/08/14.
 */
public class SystemEnvironmentTests {

    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    // This test contains no assertion, shame on us! But what can we do about it? since lazy coders sometimes do not define JAVA_HOME :)
    @Test
    public void systemEnvironmentVariableFetchedOK() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new BeanFactoryResolver(new AnnotationConfigApplicationContext(ApplicationConfig.class)));
        String value = parser.parseExpression("@systemEnvironment[JAVA_HOME]").getValue(context, String.class);
        System.out.println(value);
    }
}
