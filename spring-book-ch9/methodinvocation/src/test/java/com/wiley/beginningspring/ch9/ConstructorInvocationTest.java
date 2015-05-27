package com.wiley.beginningspring.ch9;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mertcaliskan
 * on 10/08/14.
 */
public class ConstructorInvocationTest {

    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void constructorInvocationWorksOK() {
        Expression exp = parser.parseExpression("new Double(3.141592653589793)");
        Double value = exp.getValue(Double.class);
        assertThat(value, is(3.141592653589793));
    }
}
