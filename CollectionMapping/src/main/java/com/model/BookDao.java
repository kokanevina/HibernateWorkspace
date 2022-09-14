package com.model;

import java.util.List;

import com.pojo.Book;

public interface BookDao {
		public boolean addBook(Book book);
		public List<Book> getAllBooks();
}
