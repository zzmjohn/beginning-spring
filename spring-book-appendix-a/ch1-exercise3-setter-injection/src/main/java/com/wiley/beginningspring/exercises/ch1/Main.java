package com.wiley.beginningspring.exercises.ch1;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
		applicationContext.setAllowCircularReferences(true);
		applicationContext.setConfigLocations(new String[]{"/applicationContext.xml"});
		applicationContext.refresh();
	}
}
