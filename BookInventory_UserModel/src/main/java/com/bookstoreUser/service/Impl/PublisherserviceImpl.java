package com.bookstoreUser.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreUser.models.BookPublisher;
import com.bookstoreUser.repository.PublisherRepository;
import com.bookstoreUser.service.PublisherService;

@Service
public class PublisherserviceImpl implements PublisherService
{
    @Autowired
    private PublisherRepository pubrepo;
	public List<BookPublisher> getList()
	{
		return pubrepo.findAll();
	}
	public BookPublisher getPublisher(int pubid) 
	{
		return pubrepo.findById(pubid).orElse(null);
	}
}
