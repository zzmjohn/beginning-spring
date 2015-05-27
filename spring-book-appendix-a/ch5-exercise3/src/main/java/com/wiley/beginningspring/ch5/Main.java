package com.wiley.beginningspring.ch5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
    	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Ch5Configuration.class);
        EntityManagerFactory entityManagerFactory = applicationContext.getBean(EntityManagerFactory.class);
        System.out.println(entityManagerFactory.isOpen());
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        Foo foo = new Foo();
        
        entityManager.persist(foo);
        
        entityManager.flush();
        entityManager.close();
    }
}
