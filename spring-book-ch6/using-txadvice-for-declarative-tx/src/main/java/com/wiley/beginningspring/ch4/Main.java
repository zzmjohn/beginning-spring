package com.wiley.beginningspring.ch4;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Ch4Configuration.class);
		
		AccountDao accountDao = applicationContext.getBean(AccountDao.class);
		
		Account account = new Account();
		account.setOwnerName("Joe Smith");
		account.setBalance(20.0);
		account.setAccessTime(new Date());
		account.setLocked(false);
		
		accountDao.insert(account);
		
		account = accountDao.find(account.getId());
		
		System.out.println(account.getId());
		System.out.println(account.getOwnerName());
		System.out.println(account.getBalance());
		System.out.println(account.getAccessTime());
		System.out.println(account.isLocked());
		
		account.setBalance(30.0);
		
		accountDao.update(account);
		
		account = accountDao.find(account.getId());
		System.out.println(account.getBalance());
		
		accountDao.delete(account.getId());
		
		List<Account> accounts = accountDao.find(Arrays.asList(account.getId()));
		
		System.out.println(accounts.size());
	}
}
