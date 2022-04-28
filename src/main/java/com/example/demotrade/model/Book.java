package com.example.demotrade.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author iqbalhussain
 *
 */
@Entity
@Table(name = "book")
public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5257526307725356107L;

	@Id
	@Column(name = "book_id",updatable = false, nullable = false)
	private long bookId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	
	public Book() {}

	public Book(long bookId, String title, String description) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.description = description;
	}
	
	public Book(String title, String description) {
		this.title = title;
		this.description = description;
	}



	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", description=" + description + "]";
	}
	
	
	
	
}
