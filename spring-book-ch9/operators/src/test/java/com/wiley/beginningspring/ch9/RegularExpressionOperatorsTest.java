package com.wiley.beginningspring.ch9;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mertcaliskan
 * on 12/08/14.
 */
public class RegularExpressionOperatorsTest {

    ExpressionParser p;

    @Before
    public void setup() {
        p = new SpelExpressionParser();
    }

    @Test
    public void relationalOperatorsWorkOK() {
        assertThat(p.parseExpression("35 matches '[0-9]+'").getValue(Boolean.class), is(true));
        assertThat(p.parseExpression("'John' matches '[A-Za-z]+'").getValue(Boolean.class), is(true));
    }
}
