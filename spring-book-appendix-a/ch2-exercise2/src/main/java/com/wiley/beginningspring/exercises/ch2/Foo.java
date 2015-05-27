package com.wiley.beginningspring.exercises.ch2;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;

public class Foo implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet method is called");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init method is called");
	}
	
	public void initialize() {
		System.out.println("initialize method is called");
	}

}
