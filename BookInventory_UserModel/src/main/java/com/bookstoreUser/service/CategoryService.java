package com.bookstoreUser.service;

import java.util.List;

import com.bookstoreUser.models.BookCategory;

public interface CategoryService 
{
	List<BookCategory> getList();

	BookCategory getCategory(int catid);

}
