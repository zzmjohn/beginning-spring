package com.wiley.beginningspring.ch5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Foo {
	@Id
	@GeneratedValue
	private Long id;
}
