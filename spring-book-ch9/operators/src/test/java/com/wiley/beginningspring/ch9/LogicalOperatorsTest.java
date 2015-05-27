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
public class LogicalOperatorsTest {
    ExpressionParser p;

    @Before
    public void setup() {
        p = new SpelExpressionParser();
    }

    @Test
    public void logicalOperatorsWorkOK() {
        assertThat(p.parseExpression("true && false").getValue(Boolean.class), is(false));
        assertThat(p.parseExpression("true || false").getValue(Boolean.class), is(true));
        assertThat(p.parseExpression("!false").getValue(Boolean.class), is(true));

        assertThat(p.parseExpression("true and false").getValue(Boolean.class), is(false));
        assertThat(p.parseExpression("true or false").getValue(Boolean.class), is(true));
        assertThat(p.parseExpression("not false").getValue(Boolean.class), is(true));

        assertThat(p.parseExpression("3 between {2,5}").getValue(Boolean.class), is(true));
    }
}
