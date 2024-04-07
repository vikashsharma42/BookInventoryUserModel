package com.bookstoreUser.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.bookstoreUser.models.Book;

public interface BookService 
{

	Page<Book> getList(int pn);

	Book getBook(int bid);

	List<Book> getListById(int bid);

	List<Book> getListByAutor(String author);

	List<Book> getListByTitle(String title);

	List<Book> getListByCategory(int catid);

	List<Book> getListByPublisher(int pubid);

	void updateQuantity(int quantity,int bid);
	
}
