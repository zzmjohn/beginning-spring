package com.wiley.beginningspring.ch7;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
@Transactional
public class TransactionalTests {

	@Autowired
	private SessionFactory sessionFactory;

	@BeforeTransaction
	public void setUp() {
		// setup code that will run before transaction initiation...
	}

	@AfterTransaction
	public void tearDown() {
		// cleanup code that will run after transaction completion
	}

	@Test
	@Rollback(false)
	public void testMethod1() {
		// ...
	}

	@Test
	public void testMethod2() {
		// persistence operations...
		sessionFactory.getCurrentSession().flush();
	}
}
