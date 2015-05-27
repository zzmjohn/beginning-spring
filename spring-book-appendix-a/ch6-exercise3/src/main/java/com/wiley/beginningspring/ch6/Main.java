package com.wiley.beginningspring.ch6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.beginningspring.ch5.Ch5Configuration;

public class Main {
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Ch5Configuration.class, Ch6Configuration.class);
		AccountService accountService = applicationContext.getBean(AccountService.class);
		accountService.depositMoney(100, 10.0);
	}
}
