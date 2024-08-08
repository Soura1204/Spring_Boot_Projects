package com.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.repository.BookRepository;

@Service
public class BookService {
	private  BookRepository bookRepository;
	private BookRepository bookRepository1;
	//constructor
      public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	
	public BookRepository getBookRepository1() {
		return bookRepository1;
	}
	public void setBookRepository1(BookRepository bookRepository1) {
		this.bookRepository1 = bookRepository1;
	}

    

    
}