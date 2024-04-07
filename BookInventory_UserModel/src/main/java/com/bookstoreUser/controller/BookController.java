package com.bookstoreUser.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstoreUser.models.Book;
import com.bookstoreUser.service.BookService;

@Controller
@RequestMapping("bookstore/user")
public class BookController 
{
	@Autowired
	private BookService bservice;

	@RequestMapping("booklist")
	public String getBOOKList(int pn,Model model) 
	{
		Page<Book>plist = bservice.getList(pn-1);
		int totalpage=plist.getTotalPages();
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("pn",pn);
		List<Book>list=plist.toList();
		model.addAttribute("blist", list);
		return "purchase/book-list";
	}
}
