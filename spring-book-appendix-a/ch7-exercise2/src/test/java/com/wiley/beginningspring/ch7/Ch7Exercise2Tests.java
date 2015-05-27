package com.wiley.beginningspring.ch7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Ch7Configuration.class, Ch7Exercise2Tests.Config.class})
public class Ch7Exercise2Tests {

	@Configuration
	@ImportResource("classpath:/applicationContext.xml")
	static class Config {	
	}
	
	@Autowired
	private Foo foo;
	
	@Autowired
	private Bar bar;
	
	@Test
	public void testDependenciesAreInjected() {
		Assert.assertNotNull(foo);
		Assert.assertNotNull(bar);
	}
}
