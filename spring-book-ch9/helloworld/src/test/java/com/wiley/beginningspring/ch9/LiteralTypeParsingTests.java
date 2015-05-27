package com.wiley.beginningspring.ch9;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mertcaliskan
 * on 14/08/14.
 */
public class LiteralTypeParsingTests {

    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void dateLiteralTypeParsedOK() {
        assertThat(parser.parseExpression("'2001/01/01'").getValue(Date.class), is(getTime()));
    }

    @Test
    public void hexadecimalNumericLiteralTypeParsedOK() {
        assertThat(parser.parseExpression("0xABCDEF").getValue(Integer.class), is(11259375));
    }

    @Test
    public void booleanLiteralTypeParsedOK() {
        assertThat(parser.parseExpression("false").getValue(Boolean.class), is(false));
    }

    @Test
    public void nullLiteralTypeParsedOK() {
        assertThat(parser.parseExpression("null").getValue(), nullValue());
    }

    private static Date getTime() {
        Calendar instance = Calendar.getInstance();
        instance.set(2001, 0, 1);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return instance.getTime();
    }
}