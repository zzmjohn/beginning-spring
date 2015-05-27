package com.wiley.beginningspring.ch7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Ch7ConfigurationForDependencyInjection {
	@Bean
	public Foo foo1() {
		return new Foo();
	}
	
	@Bean
	public Foo foo2() {
		return new Foo();
	}
	
	@Bean
	public Bar bar1() {
		return new Bar();
	}
}
