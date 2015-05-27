package com.wiley.beginningspring.ch2;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FooFactory {

	@Bean(name="foo3")
	public static Foo createFoo3() {
		Foo foo = new Foo();
		foo.setName("foo3");
		return foo;
	}
	
	@Bean(name="foo4")
	public Foo createFoo4() {
		Foo foo = new Foo();
		foo.setName("foo4");
		return foo;
	}
}
