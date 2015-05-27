package com.wiley.beginningspring.ch7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wiley.beginningspring.ch7.AccountService;
import com.wiley.beginningspring.ch7.Ch7Configuration;
import com.wiley.beginningspring.ch7.AccountIntegrationTestsWithMixedConfig.Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Ch7Configuration.class,Config.class})
public class AccountIntegrationTestsWithMixedConfig {

	@Configuration
	@ImportResource("classpath:/applicationContext.xml")
	static class Config {
	}
	
	
	@Autowired
	private AccountService accountService;
	
	@Test
	public void accountServiceShouldBeInjected() {
		Assert.assertNotNull(accountService);
	}
}
