package com.wiley.beginningspring.ch5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

public class Main {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Ch5Configuration.class);

		BookService bookService = applicationContext.getBean(BookService.class);

		try {
			Book book = new Book();
			book.setName(null);
			bookService.save(book);
		} catch (DataAccessException ex) {
			System.out.println("Spring dao exception handled");
		}
	}
}
