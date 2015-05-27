package com.wiley.beginningspring.ch7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wiley.beginningspring.ch7.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(initializers={TestInitializer.class})
public class AccountIntegrationTestsWithInitializer {
	@Autowired
	private AccountService accountService;
	
	@Test
	public void accountServiceShouldBeInjected() {
		Assert.assertNotNull(accountService);
	}
}
