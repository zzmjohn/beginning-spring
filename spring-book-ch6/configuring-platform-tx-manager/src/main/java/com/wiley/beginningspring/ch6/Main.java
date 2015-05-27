package com.wiley.beginningspring.ch6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Ch6Configuration.class);
		PlatformTransactionManager transactionManager = applicationContext.getBean(PlatformTransactionManager.class);
		System.out.println(transactionManager != null);
	}
}
