package com.cg.iter.service;

import com.cg.iter.bean.Author;

public interface AuthorService
{
	public boolean addAuthor(Author author);
	public boolean updateAuthor(Author author);
	public boolean deleteAuthor(int id);
	public Author findAuthor(int id);
}
