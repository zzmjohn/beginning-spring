package com.wiley.beginningspring.ch9;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mertcaliskan
 * on 10/08/14.
 */
public class StaticConstantFieldAccessInNestedClassTest {

    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void staticConstantFieldAccessInNestedClassWorksOK() {
        Expression exp = parser.parseExpression("T(com.wiley.beginningspring.ch9.domain.MyClass$MyNestedClass).VALUE");
        Integer value = exp.getValue(Integer.class);
        assertThat(value, is(10));
    }
}
