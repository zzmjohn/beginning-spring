package com.wiley.beginningspring.ch9;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mertcaliskan
 * on 15/08/14.
 */
public class InlineListTests {

    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void inlineListCreatedOK() {
        List<Integer> value = parser.parseExpression("{1,2,3}").getValue(List.class);
        assertThat(value, hasItems(1, 2, 3));
    }

    @Test
    public void inlineListOfListsCreatedOK() {
        List<List<Integer>> value = parser.parseExpression("{{1,2},{3,4},{5,6}}").getValue(List.class);
        assertThat(value, hasItems(Arrays.asList(1,2), Arrays.asList(3,4), Arrays.asList(5,6)));
    }
}
