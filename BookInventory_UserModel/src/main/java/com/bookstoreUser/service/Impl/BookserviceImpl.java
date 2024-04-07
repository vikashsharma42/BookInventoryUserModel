package com.bookstoreUser.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.bookstoreUser.models.Book;
import com.bookstoreUser.repository.BookRepository;
import com.bookstoreUser.service.BookService;

@Service
public class BookserviceImpl implements BookService
{
	@Autowired
	private BookRepository bookrepo;

	public Page<Book> getList(int pn) 
	{
		Pageable page=PageRequest.of(pn,4);
		return bookrepo.findAll(page);
	}
	public Book getBook(int bid) 
	{
		return bookrepo.findById(bid).orElse(null);
	}
	public List<Book> getListById(int bid)
	{
		return bookrepo.findByBid(bid);
	}
	public List<Book> getListByAutor(String author) 
	{
		return bookrepo.findByAuthor(author);
    }
	public List<Book> getListByTitle(String title)
	{
		return bookrepo.findByTitle(title);
	}
	public List<Book> getListByCategory(int catid) 
	{
		return bookrepo.findByCatid(catid); 
	}
	public List<Book> getListByPublisher(int pubid)
	{
		return bookrepo.findByPubid(pubid);
	}
	public void updateQuantity(int quantity,int bid) 
	{
	   bookrepo.updateBookQuantity(quantity, bid);	
	}
}
