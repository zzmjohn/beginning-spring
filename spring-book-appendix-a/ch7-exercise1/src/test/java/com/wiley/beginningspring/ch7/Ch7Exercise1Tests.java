package com.wiley.beginningspring.ch7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TestExecutionListeners(listeners={})
public class Ch7Exercise1Tests {
	@Autowired
	private Foo foo;
	
	@Test
	public void testFooIsNotAvailable() {
		Assert.assertNull(foo);
	}
}
