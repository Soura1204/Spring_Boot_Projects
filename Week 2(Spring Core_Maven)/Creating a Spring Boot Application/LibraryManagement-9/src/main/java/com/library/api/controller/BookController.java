package com.library.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.api.entity.Book;
import com.library.api.repository.BookRepository;


@RestController
@RequestMapping("api/books")
public class BookController {
//add the dependency BookRepository interface 	
	@Autowired
	BookRepository bookRepository;
	
@GetMapping("/test")
public String test()
{
	return "Welcome to Book API";
}
//creating a route map for adding the new book
@PostMapping("/add")
public Book addBook(@RequestBody Book book)
{
	//calling the repository method save
	//if id=0 then create new record
	//if >0 update the record
	return bookRepository.save(book);
}
//route mapping for edit
@PutMapping("/edit")
public Book updateBook(@RequestBody Book book)
{
	//update the record with passing the object with id to update
	//it will update the records
	return bookRepository.save(book);
}
//this root mapping
@GetMapping("/")
public List<Book> getAllBooks()
{
	//returns all the exiting records
	List<Book> books=bookRepository.findAll();
	return books;
}
//mapping to get the records by id
@GetMapping("/{id}")
public Book getBook(@PathVariable int id)
{
	//returns only one object if found returns null if not found
	Book book=bookRepository.findById(id).get();
	return book;
}
//route mapping to delete the record by id
@DeleteMapping("/delete/{id}")
public String getBookDelete(@PathVariable int id)
{
	Book book=bookRepository.findById(id).get();
	if(book!=null)
	{
		bookRepository.deleteById(id);
		return "Book with "+id+" is deleted successfully";
	}
	
		
	return "Book with "+id+" not found";
	
}
}