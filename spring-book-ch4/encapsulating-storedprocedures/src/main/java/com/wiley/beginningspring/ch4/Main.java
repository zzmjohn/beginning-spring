package com.wiley.beginningspring.ch4;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Ch4Configuration.class);
			
		ConcatStoredProcedure storedProcedure = applicationContext.getBean(ConcatStoredProcedure.class);
		
		String result = storedProcedure.execute("hello ", "world!");
		
		System.out.println(result);

	}
}
