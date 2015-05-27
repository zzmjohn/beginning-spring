package com.wiley.beginningspring.ch2;

public class Foo {

	private Bar bar;
	private Baz baz;

	public Foo(Bar bar, Baz baz) {
		this.bar = bar;
		this.baz = baz;
	}

	public Foo(Baz baz, Bar bar) {
		this.bar = bar;
		this.baz = baz;
	}

	public Foo(Bar bar) {
		this.bar = bar;
	}

	public void setBaz(Baz baz) {
		this.baz = baz;
	}
}
