package com.wiley.beginningspring.exercises.ch2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		boolean containsFoo = applicationContext.containsBean("foo");
		System.out.println(containsFoo);
	}

}
