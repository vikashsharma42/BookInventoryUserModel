package com.bookstoreUser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstoreUser.models.BookCategory;
import com.bookstoreUser.service.CategoryService;

@Controller
@RequestMapping("bookstore/user/")
public class CategoryController 
{
	@Autowired
	private CategoryService catservice;

	@RequestMapping("category/details")
	public String getCategoryDetails(int cid,Model model)
	{
		BookCategory cat=catservice.getCategory(cid);
		model.addAttribute("cat",cat);
		return "category/category-details";
	}
}
