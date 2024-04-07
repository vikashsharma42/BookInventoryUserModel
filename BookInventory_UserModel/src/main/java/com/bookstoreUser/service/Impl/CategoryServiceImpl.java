package com.bookstoreUser.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreUser.models.BookCategory;
import com.bookstoreUser.repository.CategoryRepository;
import com.bookstoreUser.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
	private CategoryRepository catrepo;

	public List<BookCategory> getList()
	{
		return catrepo.findAll();
	}
	public BookCategory getCategory(int catid) 
	{
	    return catrepo.findById(catid).orElse(null);
	}
}
