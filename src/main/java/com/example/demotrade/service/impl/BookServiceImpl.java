/**
 * 
 */
package com.example.demotrade.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demotrade.model.Book;
import com.example.demotrade.repository.BookRepository;
import com.example.demotrade.service.BookService;

/**
 * @author iqbalhussain
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> findAll(String title) {
		List<Book> books = new ArrayList<Book>();
		if (title == null)
			bookRepository.findAll().forEach(books::add);
		else
			bookRepository.findByTitleContaining(title).forEach(books::add);
		return books;
	}

	@Override
	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(new Book(book.getTitle(), book.getDescription()));
	}

	@Override
	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}

}
