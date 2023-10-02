package com.library.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.library.sb.entity.Book;
import com.library.sb.service.BookService;

import jakarta.validation.Valid;

@RestController
public class BookController {
	
	@Autowired
	BookService bs;
	
	//use postmapping to insert data 
		@PostMapping("/addBook")
		public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book){
			return new ResponseEntity<Book>(bs.addBook(book),
					HttpStatus.CREATED);
		}
		
		//use getmapping to fetch data from db table
		@GetMapping("getBook/{bid}")
		public ResponseEntity<Book> getBook(@PathVariable("bid") int bid){
			return new ResponseEntity<Book>(bs.getBookDetail(bid),HttpStatus.OK);
		}
		
		//use putmapping to edit existing data
		@PutMapping("/editBook/{bid}")
		public ResponseEntity<Book> editBook(@Valid @PathVariable("bid") int bid, @RequestBody Book book){
			return new ResponseEntity<Book>(bs.updateBookDetail(book, bid), HttpStatus.OK);
		}
		
		
		//use deletemapping to remove existing data
		@DeleteMapping("removeBook/{bid}")
		public ResponseEntity<String> deleteBook(@PathVariable("bid") int bid){
			bs.deleteBookDetail(bid);
			return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
		}

}
