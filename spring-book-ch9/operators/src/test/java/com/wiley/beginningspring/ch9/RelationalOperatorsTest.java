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
public class RelationalOperatorsTest {

    ExpressionParser p;

    @Before
    public void setup() {
        p = new SpelExpressionParser();
    }

    @Test
    public void relationalOperatorsWorkOK() {
        assertThat(p.parseExpression("1<2").getValue(Boolean.class), is(true));
        assertThat(p.parseExpression("2>1").getValue(Boolean.class), is(true));
        assertThat(p.parseExpression("3<=3").getValue(Boolean.class), is(true));
        assertThat(p.parseExpression("3>=3").getValue(Boolean.class), is(true));
        assertThat(p.parseExpression("3==3").getValue(Boolean.class), is(true));
        assertThat(p.parseExpression("3!=4").getValue(Boolean.class), is(true));

        assertThat(p.parseExpression("1 lt 2").getValue(Boolean.class), is(true));
        assertThat(p.parseExpression("2 gt 1").getValue(Boolean.class), is(true));
        assertThat(p.parseExpression("3 le 3").getValue(Boolean.class), is(true));
        assertThat(p.parseExpression("3 ge 3").getValue(Boolean.class), is(true));
        assertThat(p.parseExpression("3 eq 3").getValue(Boolean.class), is(true));
        assertThat(p.parseExpression("3 ne 4").getValue(Boolean.class), is(true));
    }
}
