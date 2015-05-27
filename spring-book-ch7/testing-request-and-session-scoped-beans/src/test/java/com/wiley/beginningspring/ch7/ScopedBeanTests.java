package com.wiley.beginningspring.ch7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wiley.beginningspring.ch7.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:/applicationContext.xml")
public class ScopedBeanTests {
	@Autowired
	private UserService userService;
	
	@Autowired
	private MockHttpServletRequest httpServletRequest;
	
	@Autowired
	private MockHttpSession httpSession;
	
	@Test
	public void testScopedBeans() {
		httpServletRequest.setParameter("username", "jdoe");
		httpServletRequest.setParameter("password", "secret");
		
		httpSession.setAttribute("theme", "blue");
		
		Assert.assertEquals("jdoe",userService.getLoginAction().getUsername());
		Assert.assertEquals("secret", userService.getLoginAction().getPassword());
		Assert.assertEquals("blue", httpSession.getAttribute("theme"));
	}
}
