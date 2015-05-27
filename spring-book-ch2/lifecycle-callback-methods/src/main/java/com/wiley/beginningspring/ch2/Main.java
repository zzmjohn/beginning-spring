package com.wiley.beginningspring.ch2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		applicationContext.registerShutdownHook();
	}

}
