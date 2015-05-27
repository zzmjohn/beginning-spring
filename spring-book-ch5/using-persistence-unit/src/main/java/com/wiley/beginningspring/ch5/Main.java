package com.wiley.beginningspring.ch5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Ch5Configuration.class);

		StudentDaoJpaImpl dao = applicationContext.getBean(StudentDaoJpaImpl.class);

		Student student = new Student();
		student.setFirstName("Joe");
		student.setLastName("Smith");

		dao.save(student);
	}

}