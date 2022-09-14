package com.model;

import java.util.List;

import com.pojo.Author;


public interface AuthorDao {
	public boolean addAuthor(Author author);
	public List<Author> getAllAuhtors();
}
