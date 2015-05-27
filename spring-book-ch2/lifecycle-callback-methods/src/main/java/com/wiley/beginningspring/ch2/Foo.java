package com.wiley.beginningspring.ch2;

public class Foo {
	public void init() throws Exception {
		System.out.println("init method invoked");
	}
	
	public void destroy() throws RuntimeException {
		System.out.println("destroy method invoked");
	}
}
