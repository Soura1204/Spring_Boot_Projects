package com.library.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.api.entity.Book;

//extending the class JpaRepository provides all the CRUD method or functions
public interface BookRepository extends JpaRepository<Book,Integer> {

}
