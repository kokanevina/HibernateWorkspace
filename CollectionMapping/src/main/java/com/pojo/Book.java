package com.pojo;


public class Book {
	
	private int bookId;
	
	private String bookName;
	private double bookPrice;
	private Author author; // one to one
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String bookName, double bookPrice, Author author) {
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.author = author;
	}
	public Book(int bookId, String bookName, double bookPrice, Author author) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.author = author;
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
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", author=" + author
				+ "]";
	}
	
	
	
}
