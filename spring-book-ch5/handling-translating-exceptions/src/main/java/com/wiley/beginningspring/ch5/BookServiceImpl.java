package com.wiley.beginningspring.ch5;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    
    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

}
