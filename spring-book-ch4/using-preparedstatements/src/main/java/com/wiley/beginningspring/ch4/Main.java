package com.wiley.beginningspring.ch4;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Ch4Configuration.class);
		DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
		
		Connection connection = dataSource.getConnection();
		System.out.println(connection.isClosed());
		connection.close();
		System.out.println(connection.isClosed());
		
		AccountDao accountDao = applicationContext.getBean(AccountDao.class);
		
		Account account = accountDao.find(false).get(0);
		
		System.out.println(account.getId());
		System.out.println(account.getOwnerName());
		System.out.println(account.getBalance());
		System.out.println(account.getAccessTime());
		System.out.println(account.isLocked());
	}
}
