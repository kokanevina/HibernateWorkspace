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
		try(Session session=sfactory.openSession();){
			Transaction tr=session.beginTransaction();
			TypedQuery<Book> query=session.createQuery("from Book", Book.class); // HQL Employee : pojo class name 
			bookList= query.getResultList();
			tr.commit();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		return bookList;
	}
	
} 
	  
	  
	  
	  
	 
	
	
	
	

