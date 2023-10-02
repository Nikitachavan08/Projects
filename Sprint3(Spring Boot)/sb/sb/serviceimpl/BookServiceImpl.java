package com.library.sb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.sb.entity.Book;
import com.library.sb.exception.BookIdNotFoundException;
import com.library.sb.repository.BookRepository;
import com.library.sb.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository brepo;
	
	@Override
	public Book addBook(Book book) {
		
		return brepo.save(book);
	}

	@Override
	public Book getBookDetail(int bid) {
		
		return brepo.findById(bid).orElseThrow(()-> new BookIdNotFoundException("Book Id is not correct"));
		}

	@Override
	public Book updateBookDetail(Book book, int bid) {
	
		Book updatedBook = brepo.findById(bid).orElseThrow(()-> new BookIdNotFoundException("Book Id is not correct"));

		//set new values
		updatedBook.setBprice(book.getBprice());
		updatedBook.setBdescription(book.getBdescription());
		
		brepo.save(updatedBook); //saving updated details 
			return updatedBook; 
		}

	@Override
	public void deleteBookDetail(int bid) {
		brepo.findById(bid).
		orElseThrow(()-> new BookIdNotFoundException("Book Id is not correct"));
	    brepo.deleteById(bid);
	}


}
