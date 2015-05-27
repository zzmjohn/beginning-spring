package com.wiley.beginningspring.ch5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = 
            new AnnotationConfigApplicationContext(Ch5Configuration.class);
        
        BookService bookService = applicationContext.getBean(BookService.class);
        
        Book book = new Book();
        book.setName("book1");
        bookService.save(book);
    }
}
