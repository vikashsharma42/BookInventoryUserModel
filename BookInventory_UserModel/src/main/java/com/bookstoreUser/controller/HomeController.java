package com.bookstoreUser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookstore/user")
public class HomeController
{
	@RequestMapping("home")
    public String getHomeView()
    {
  	   return"home/home";
    }
}
