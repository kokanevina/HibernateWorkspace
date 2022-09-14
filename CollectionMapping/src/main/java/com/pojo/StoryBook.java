package com.pojo;

import java.util.Set;

public class StoryBook {
	private int bookId;
	private String bookName;
	private double bookPrice;
	private Set<Author> authors; // one Story Book having many Author objects
	public StoryBook() {
		// TODO Auto-generated constructor stub
	}
	public StoryBook(int bookId, String bookName, double bookPrice, Set<Author> authors) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.authors = authors;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	@Override
	public String toString() {
		return "StoryBook [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", authors="
				+ authors + "]";
	}
	
	
	
}
