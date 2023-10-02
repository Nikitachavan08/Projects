package com.library.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.sb.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
	

}
