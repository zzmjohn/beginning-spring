package com.wiley.beginningspring.ch2;

import java.util.Collections;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(Ch2Configuration.class);
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		environment.setActiveProfiles("dev");
		MutablePropertySources propertySources = environment.getPropertySources();
		propertySources.addLast(new MapPropertySource("mapSource", Collections.singletonMap("name", (Object)"my foo")));
		applicationContext.refresh();
		
		Foo foo = applicationContext.getBean(Foo.class);
		System.out.println(foo.getName());
	}

}
