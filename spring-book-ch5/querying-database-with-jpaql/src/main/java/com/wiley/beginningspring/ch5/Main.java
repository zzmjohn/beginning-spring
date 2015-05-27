package com.wiley.beginningspring.ch5;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    
	public static void main(String[] args) {
	    EntityManagerFactory entityManagerFactory = 
	        Persistence.createEntityManagerFactory("test-jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    Query query = entityManager.createQuery(
	            "select s from Student s where s.firstName like ?");
	    query.setParameter(1, "Jo%");
	    List<Student> students = query.getResultList();
	    Student s = students.get(0);
	    System.out.println(students.size());
	    System.out.println(s.getFirstName());
	    entityManager.close();
	}

}
