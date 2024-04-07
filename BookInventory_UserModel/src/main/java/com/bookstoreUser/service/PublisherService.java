package com.bookstoreUser.service;

import java.util.List;

import com.bookstoreUser.models.BookPublisher;

public interface PublisherService 
{

	List<BookPublisher> getList();
	BookPublisher getPublisher(int pubid);
}
