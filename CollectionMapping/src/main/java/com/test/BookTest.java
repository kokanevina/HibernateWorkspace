package com.test;

import com.model.AuthorCrud;
import com.model.BookCrud;
import com.pojo.Author;
import com.pojo.Book;

public class BookTest {

	public static void main(String[] args) {
		BookCrud bookcrud=new BookCrud();
		AuthorCrud authcrud=new AuthorCrud();
		
		Author auth=new Author(156,"Ramesh Kumar", 30);
		boolean b1=authcrud.addAuthor(auth);
		Book book=new Book("Learn Basics of Python",550,auth);
		boolean b2=bookcrud.addBook(book);
		System.out.println(b1);
		
		// getAllBooks
	}

}
