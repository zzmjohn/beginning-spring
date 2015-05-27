package com.wiley.beginningspring.ch9;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import static org.junit.Assert.assertTrue;

/**
 * Created by mertcaliskan
 * on 10/08/14.
 */
public class StaticMethodInvocationTest {

    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void staticMethodCallWorksOK() {
        Expression exp = parser.parseExpression("T(java.lang.Math).random()");
        Double value = exp.getValue(Double.class);
        assertTrue(0 < value);
        assertTrue(1 > value);
    }
}
