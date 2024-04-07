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
public class UserProfileController
{
	@Autowired
	private UserService service;
	
	@RequestMapping("profile")
	public String getProfile(Model model,HttpSession ses)
	{
		User user=service.getUser((String)ses.getAttribute("userid"));
		model.addAttribute("user",user);
		ses.setAttribute("user",user);
		return"profile/user-detail";
	}
	@RequestMapping("editprofile")
	public String getEditProfile(Model model,HttpSession ses)
	{
		User user=(User)ses.getAttribute("user");
		model.addAttribute("user",user);
		return"profile/edit-details";
	}
	@RequestMapping("updateprofile")
	public String updateProfile(User user,Model model,HttpSession ses)
	{
		service.updateUser(user);
		ses.setAttribute("name",user.getName());
		ses.setAttribute("user",user);
		model.addAttribute("msg","Your profile has been updated");
		return"profile/user-detail";
	}
    @RequestMapping("changepass")
    public String changePassword()
    {
    	return"profile/change-password";
    }
    @RequestMapping("checkpass")
    public String checkPassword(String pass,HttpSession ses,Model model)
    {
    	User user=(User)ses.getAttribute("user");
    	if(!user.getPassword().equals(pass))
    	{
    		model.addAttribute("msg","Current password is wrong");
    		return"profile/change-password";
    	}
		return"profile/new-password";
    }
    @RequestMapping("updatepass")
    public String updatePassword(String pass,HttpSession ses,Model model)
    {
    	User user=(User)ses.getAttribute("user");
    	if(user.getPassword().equals(pass))
    	{
    		model.addAttribute("msg","This is your current password.Please change password ");
    		return"profile/new-password";
    	}
    	String uid=(String)ses.getAttribute("userid");
    	service.updatePassword(pass,uid);
    	model.addAttribute("name",ses.getAttribute("name"));
		ses.invalidate();
    	return "profile/password-updated";
    }
}
