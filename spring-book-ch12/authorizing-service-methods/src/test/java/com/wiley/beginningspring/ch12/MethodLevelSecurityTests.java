package com.wiley.beginningspring.ch12;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wiley.beginningspring.ch12.BusinessService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class MethodLevelSecurityTests {
	@Autowired
	private BusinessService businessService;
	
	@After
	public void tearDown() {
		SecurityContextHolder.clearContext();
	}
	
	@Test(expected=AuthenticationCredentialsNotFoundException.class)
	public void testSecureMethodWithoutAuthentication() {
		businessService.secureMethod();
	}
	
	@Test(expected=AccessDeniedException.class)
	public void testSecureMethodWithoutAppropriateAuthority() {
		TestingAuthenticationToken authentication = new TestingAuthenticationToken("user1", "secret");
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		businessService.secureMethod();
	}
	
	@Test
	public void testSecureMethodWithAppropriateAuthority() {
		TestingAuthenticationToken authentication = new TestingAuthenticationToken("user1", "secret","ROLE_USER");
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		businessService.secureMethod();
	}
}
