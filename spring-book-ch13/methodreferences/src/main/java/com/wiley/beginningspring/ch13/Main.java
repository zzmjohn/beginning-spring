package com.wiley.beginningspring.ch13;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String... args) throws SQLException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		AccountDao accountDao = applicationContext.getBean(AccountDao.class);
		Account account = accountDao.find(100L);
		
		System.out.println(account);
	}
}
