package com.bookstoreUser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstoreUser.models.Book;
import com.bookstoreUser.models.BookCategory;
import com.bookstoreUser.models.BookPublisher;
import com.bookstoreUser.service.BookService;
import com.bookstoreUser.service.CategoryService;
import com.bookstoreUser.service.PublisherService;

@Controller
@RequestMapping("bookstore/user")
public class SearchBookController 
{
	@Autowired
	private BookService bservice;
	@Autowired
	private CategoryService cservice;
	@Autowired PublisherService pservice;
	@RequestMapping("searchbook")
    public String getSearchView(Model model)
    {
		List<BookCategory>clist=cservice.getList();
		List<BookPublisher>plist=pservice.getList();
		model.addAttribute("clist",clist);
		model.addAttribute("plist",plist);
    	return"search/search-books"; 
    }
	@RequestMapping("searchbook/byid")
	private String searchBookByid(int bid,Model model)
	{
		List<Book>list=bservice.getListById(bid);
		model.addAttribute("blist",list);
		model.addAttribute("by","id");
		return"search/search-book-list";
	}
	@RequestMapping("searchbook/byauthor")
	private String searchBookByAuthor(String author,Model model)
	{
		List<Book>list=bservice.getListByAutor(author);
		model.addAttribute("blist",list);
	    model.addAttribute("by","author");
		return"search/search-book-list";
	}
	@RequestMapping("searchbook/bytitle")
	private String searchBookByTitle(String title,Model model)
	{
		List<Book>list=bservice.getListByTitle(title);
		model.addAttribute("blist",list);
	    model.addAttribute("by","title");
		return"search/search-book-list";
	}
	@RequestMapping("searchbook/bycategory")
	private String searchBookByCategory(int catid,Model model)
	{
		List<Book>list=bservice.getListByCategory(catid);
		model.addAttribute("blist",list);
	    model.addAttribute("by","category");
		return"search/search-book-list";
	}
	@RequestMapping("searchbook/bypublisher")
	private String searchBookByPublisher(int pubid,Model model)
	{
		List<Book>list=bservice.getListByPublisher(pubid);
		model.addAttribute("blist",list);
	    model.addAttribute("by","publisher");
		return"search/search-book-list";
	}
}
