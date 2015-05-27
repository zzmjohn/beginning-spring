package com.wiley.beginningspring.ch2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Bar {
	@PostConstruct
	public void init() throws Exception {
		System.out.println("init method invoked");
	}
	
	@PreDestroy
	public void destroy() throws RuntimeException {
		System.out.println("destroy method invoked");
	}	
}
