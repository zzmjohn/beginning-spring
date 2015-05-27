package com.wiley.beginningspring.ch9;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by mertcaliskan
 * on 10/08/14.
 */
public class ArithmeticOperatorsTest {

    ExpressionParser p;

    @Before
    public void setup() {
        p = new SpelExpressionParser();
    }

    @Test
    public void arithmeticOperatorsWorkOK() {
        assertThat(p.parseExpression("1+1").getValue(Integer.class), is(2));
        assertThat(p.parseExpression("1-1").getValue(Integer.class), is(0));
        assertThat(p.parseExpression("2*2").getValue(Integer.class), is(4));
        assertThat(p.parseExpression("2/2").getValue(Integer.class), is(1));
        assertThat(p.parseExpression("5%2").getValue(Integer.class), is(1));
        assertThat(p.parseExpression("2^3").getValue(Integer.class), is(8));

        assertThat(p.parseExpression("5 mod 2").getValue(Integer.class), is(1));
    }
}
