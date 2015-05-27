package com.wiley.beginningspring.ch2;

import org.springframework.beans.factory.FactoryBean;

public class FooFactoryBean implements FactoryBean<Foo> {

	@Override
	public Foo getObject() throws Exception {
		Foo foo = new Foo();
		foo.setName("foo5");
		return foo;
	}

	@Override
	public Class<?> getObjectType() {
		return Foo.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
