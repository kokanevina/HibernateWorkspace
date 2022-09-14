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

public class AuthorCrud implements AuthorDao{
	SessionFactory sfactory;
	public AuthorCrud() {
			sfactory=MyConnection.connect();
			System.out.println("Connection Done.......");
	}
	@Override
	public boolean addAuthor(Author author) {
		boolean b=false;
		try(Session session=sfactory.openSession();){
		Transaction tr=session.beginTransaction();
		Serializable id2= session.save(author); // insert query  // persists
		tr.commit();
		b=true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Author> getAllAuhtors() {

		List<Author> authorList=null;
		try(Session session=sfactory.openSession();){
			Transaction tr=session.beginTransaction();
			TypedQuery<Author> query=session.createQuery("from Author", Author.class); // HQL Employee : pojo class name 
			authorList= query.getResultList();
			tr.commit();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		return authorList;
	}

}
