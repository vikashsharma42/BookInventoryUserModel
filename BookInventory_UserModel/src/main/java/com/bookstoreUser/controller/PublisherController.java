package com.bookstoreUser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstoreUser.models.BookPublisher;
import com.bookstoreUser.service.PublisherService;

@Controller
@RequestMapping("bookstore/user")
public class PublisherController 
{
	@Autowired
	private PublisherService pubservice;
	@RequestMapping("publisher/list")
	private String getPublisherList(Model model)
	{
		List<BookPublisher>list=pubservice.getList();
		model.addAttribute("plist",list);
		return "publisher/publisher-list";
	}
	@RequestMapping("publisher/details")
	public String getPublisherDetails(int pid,Model model)
	{
		BookPublisher pub=pubservice.getPublisher(pid);
		model.addAttribute("pub",pub);
		return "publisher/publisher-details";
	}
}
