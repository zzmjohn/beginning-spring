package com.wiley.beginningspring.ch7;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wiley.beginningspring.ch7.Bar;
import com.wiley.beginningspring.ch7.Ch7ConfigurationForDependencyInjection;
import com.wiley.beginningspring.ch7.Foo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Ch7ConfigurationForDependencyInjection.class)
public class DependencyInjectionTests {
	
	@Autowired
	@Qualifier("foo1")
	private Foo foo1;
	
	@Resource
	private Foo foo2;
	
	@Resource
	private Bar bar;
	
	@Test
	public void testInjections() {
		Assert.assertNotNull(foo1);
		Assert.assertNotNull(foo2);
		Assert.assertNotNull(bar);
	}

}
