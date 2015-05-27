package com.wiley.beginningspring.ch7;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wiley.beginningspring.ch7.Foo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/baseContext.xml")
public class BaseTest {
	@Autowired
	protected Foo foo;
}
