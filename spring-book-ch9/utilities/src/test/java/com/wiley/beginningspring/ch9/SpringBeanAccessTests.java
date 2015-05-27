package com.wiley.beginningspring.ch9;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.*;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mertcaliskan
 * on 14/08/14.
 */
public class SpringBeanAccessTests {

    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void springBeanAccessWorksOK() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new BeanFactoryResolver(new AnnotationConfigApplicationContext(ApplicationConfig.class)));
        Expression exp = parser.parseExpression("@myBean.sayHello()");
        String value = exp.getValue(context, String.class);
        assertThat(value, is("Hello!"));
    }
}
