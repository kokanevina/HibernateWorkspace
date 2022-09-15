package com.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="storybook")
public class StoryBook {
	@Id
	@Column(name = "book_id")
	private int bookId;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "book_price")
	private double bookPrice;
	@OneToMany(targetEntity = Author.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "b_id")
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
