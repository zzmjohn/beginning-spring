package com.wiley.beginningspring.ch9;

import com.wiley.beginningspring.ch9.domain.Country;
import com.wiley.beginningspring.ch9.domain.Worker;
import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mertcaliskan
 * on 14/08/14.
 */
public class CollectionProjectionTests {

    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void collectionProjectedOK() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setRootObject(Arrays.asList(
                new Worker("Mert", Country.DE),
                new Worker("Funda", Country.TR),
                new Worker("Tugce", Country.USA)));
        List<Country> birthPlaces = parser.parseExpression("#root.![#this.birthPlace]").getValue(context, List.class);
        assertThat(birthPlaces, hasItems(Country.TR, Country.USA, Country.DE));
    }
}
