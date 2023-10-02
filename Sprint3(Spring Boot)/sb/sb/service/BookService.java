package com.library.sb.service;

import com.library.sb.entity.Book;

public interface BookService {
	//method for saving Book details in db table
		Book addBook(Book book);
		
		//method to fetch Book detail based on bid from db table
		Book getBookDetail(int bid);
		
		//method to modify Book detail based on bid from db table
		Book updateBookDetail(Book book, int bid);
		
		//method to remove Book detail based on bid from db table
		void deleteBookDetail(int bid);
		

}
