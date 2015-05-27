package com.wiley.beginningspring.ch5;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("test-jpa");
        System.out.println(entityManagerFactory.isOpen());
    }
}
