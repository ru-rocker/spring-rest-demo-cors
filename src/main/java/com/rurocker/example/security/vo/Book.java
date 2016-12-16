package com.rurocker.example.security.vo;

/**
 * Book domain model
 * 
 * @author ru-rocker
 *
 */
public class Book {

	private String bookId;
	private String author;
	private String title;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
