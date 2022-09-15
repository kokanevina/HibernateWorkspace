package com.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.db.MyConnection;
import com.pojo.Author;
import com.pojo.Book;
import com.pojo.StoryBook;
public class BookCrud  implements BookDao{
	SessionFactory sfactory;
	public BookCrud() {
			sfactory=MyConnection.connect();
			System.out.println("Connection Done.......");
	}
	public boolean addBook(Book book) {
		boolean b=false;
		try(Session session=sfactory.openSession();){
		Transaction tr=session.beginTransaction();
		Serializable id2= session.save(book); // insert query  // persists
		tr.commit();
		b=true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	 
	public List<Book> getAllBooks() 
	{ 
		List<Book> bookList=null;
		    Session session=sfactory.openSession();
			Transaction tr=session.beginTransaction();
			TypedQuery<Book> query=session.createQuery("from Book", Book.class); // HQL Employee : pojo class name 
			bookList= query.getResultList();
			tr.commit();
			
		return bookList;
	}
	
	public List<StoryBook> getAllStoryBooks() 
	{ 
		List<StoryBook> bookList=null;
		    Session session=sfactory.openSession();
			Transaction tr=session.beginTransaction();
			TypedQuery<StoryBook> query=session.createQuery("from StoryBook", StoryBook.class); // HQL Employee : pojo class name 
			bookList= query.getResultList();
			tr.commit();
			
		return bookList;
	}
	
	public boolean addBook(StoryBook book) {
		boolean b=false;
		try(Session session=sfactory.openSession();){
		Transaction tr=session.beginTransaction();
		Serializable id2= session.save(book); // insert query  // persists
		tr.commit();
		b=true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public StoryBook getBookId(int bookId) {
		StoryBook book=null;
		try(Session session=sfactory.openSession();){
			Transaction tr=session.beginTransaction();
			book=session.get(StoryBook.class,bookId);
			tr.commit();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	@Override
	public boolean deleteBook(int bookId) {
		boolean b=false;
		try(Session session=sfactory.openSession();){
		Transaction tr=session.beginTransaction();
		StoryBook book=getBookId(bookId);
		session.delete(book);
		tr.commit();
		b=true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
} 
	  
	  
	  
	  
	 
	
	
	
	

