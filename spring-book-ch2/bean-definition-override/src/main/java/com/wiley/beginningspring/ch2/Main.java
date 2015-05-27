package com.wiley.beginningspring.ch2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Configuration1.class, Configuration2.class);
		Foo foo = applicationContext.getBean(Foo.class);
		System.out.println(foo.getName());
	}

}
