package com.bookstoreUser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstoreUser.models.User;
import com.bookstoreUser.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("bookstore/user")
public class UserController
{
	@Autowired
	private UserService userservice;
	
	
	@RequestMapping("login")
	private String getLoginView()
	{
		return"user/login";
	}
	@RequestMapping("registration")
	private String getRegistrationView(Model model)
	{
		model.addAttribute("user",new User());
		return"user/registration";
	}
	@RequestMapping("registered")
	private String createUserAccouunt(User user,Model model)
	{
		String uid=user.getUserid();
		boolean userexist=userservice.isUserExist(uid);
		if(userexist)
		{
			model.addAttribute("user",user);
			model.addAttribute("msg","userid is already exists");
			return"user/registration";
		}
		userservice.createAccount(user);
		model.addAttribute("name",user.getName());
		return"user/register";
	}
	@RequestMapping("authentication")
	private String authenticateUser(String uid,String pass,Model model,HttpSession ses)
	{
		User user=userservice.getUser(uid);
		if(user!=null)
		{
			String dpass=user.getPassword();
			if(pass.equals(dpass))
			{
				ses.setAttribute("userid",user.getUserid());
				ses.setAttribute("name",user.getName());
				return"redirect:home"; 
			}
			else
				model.addAttribute("msg","Wrong password!!!!");
		}
		else
			model.addAttribute("msg","Wrong userid!!!");
		 model.addAttribute("userid",uid);
		return"user/login";
	}
	@RequestMapping("logout")
	private String logoutUser(HttpSession ses,Model model)
	{
		model.addAttribute("name",ses.getAttribute("name"));
		ses.invalidate();
		return"user/logout";
	}
}
