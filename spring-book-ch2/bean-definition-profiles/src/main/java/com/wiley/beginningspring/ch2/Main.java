package com.wiley.beginningspring.ch2;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
//		applicationContext.getEnvironment().setActiveProfiles("dev");
//		applicationContext.load("classpath:/applicationContext-profile.xml");
//		applicationContext.refresh();
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext-profile.xml");
	}

}
