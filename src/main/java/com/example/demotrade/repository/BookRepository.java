package com.example.demotrade.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demotrade.model.Book;

/**
 * @author iqbalhussain
 *
 */

public interface BookRepository extends JpaRepository<Book, Long> {

	
	List<Book> findByTitleContaining(String title);
}
