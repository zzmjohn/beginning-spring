package com.wiley.beginningspring.exercises.ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Ch2Exercise3Configuration {
	@Bean
	@Autowired
	public Foo foo() {
		Foo foo = new Foo();
		//foo.setBar(bar());
		return foo;
	}
	
	@Bean
	@Autowired
	public Bar bar() {
		Bar bar = new Bar();
		//bar.setFoo(foo());
		return bar;
	}
}
