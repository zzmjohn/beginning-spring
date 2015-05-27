package com.wiley.beginningspring.ch7;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Ch7Exercise3Tests.Config.class)
public class Ch7Exercise3Tests {

	@Autowired
	private Foo foo;
	
	@Configuration
	static class Config {
		@Bean
		public Foo foo() {
			return new Foo();
		}
	}
	
	@Before
	public void setUp() throws NamingException {
		SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
		builder.bind("foo", foo);
		builder.activate();
	}
	
	@Test
	public void testJNDIContextAccess() throws NamingException{
		InitialContext initialContext = new InitialContext();
		Foo foo2 = (Foo) initialContext.lookup("foo");
		
		Assert.assertSame(foo, foo2);
	}
}
