package com.wiley.beginningspring.ch5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Ch5Configuration.class);
		EntityManagerFactory entityManagerFactory = applicationContext
				.getBean(EntityManagerFactory.class);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Student student = new Student();
		student.setFirstName("Jimmy");
		student.setLastName("Smith");

		entityManager.persist(student);

		transaction.commit();
		entityManager.close();

	}

}