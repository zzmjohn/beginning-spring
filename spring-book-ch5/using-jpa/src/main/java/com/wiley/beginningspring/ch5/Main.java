package com.wiley.beginningspring.ch5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    
	public static void main(String[] args) {
	    EntityManagerFactory entityManagerFactory = 
	        Persistence.createEntityManagerFactory("test-jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();
	    transaction.begin();
	    Student student = entityManager.find(Student.class, 1L);
	    Book book2 = entityManager.getReference(Book.class, 2L);
	    student.setFirstName("Joe");
	    entityManager.remove(book2);
	    transaction.commit();
	    entityManager.close();
	}

}
