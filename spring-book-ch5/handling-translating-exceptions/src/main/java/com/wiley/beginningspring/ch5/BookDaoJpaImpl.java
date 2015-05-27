package com.wiley.beginningspring.ch5;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class BookDaoJpaImpl implements BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Book book) {
        entityManager.persist(book);
    }
}
