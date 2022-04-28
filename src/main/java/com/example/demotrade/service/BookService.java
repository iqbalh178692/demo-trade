package com.example.demotrade.service;

import java.util.List;
import java.util.Optional;

import com.example.demotrade.model.Book;

/**
 * @author iqbalhussain
 *
 */
public interface BookService {

	/**
	 * @return list of books
	 */
	List<Book> findAll(String title);
	
	/**
	 * 
	 * @param id
	 * @return book 
	 */
	Optional<Book> findById(Long id);
	
	/**
	 * 
	 * @param book
	 * @return book
	 */
	Book save(Book book);
	
	void deleteById(Long id);
}
