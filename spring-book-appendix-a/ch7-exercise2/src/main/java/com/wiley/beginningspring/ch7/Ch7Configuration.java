package com.wiley.beginningspring.ch7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Ch7Configuration {
	@Bean
	public Bar bar() {
		return new Bar();
	}
}
