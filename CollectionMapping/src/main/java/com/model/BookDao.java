package com.model;

import java.util.List;

import com.pojo.Book;
import com.pojo.StoryBook;

public interface BookDao {
		public boolean addBook(Book book);
		public List<Book> getAllBooks();
		
		public StoryBook getBookId(int bookId);
		public boolean deleteBook(int bookId);
}
