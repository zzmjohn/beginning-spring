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
 * on 09/08/14.
 */
public class NestedMethodInvocationStringConcatTest {

    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void helloParsedAndConcatenatedWithWorldAndThenLengthMethodInvoked() {
        Expression exp = parser.parseExpression("'Hello'.concat(' World!').length()");
        Integer value = exp.getValue(Integer.class);
        assertThat(value, is(12));
    }
}
