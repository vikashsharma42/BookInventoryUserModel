package com.bookstoreUser.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreUser.models.User;
import com.bookstoreUser.repository.UserRepository;
import com.bookstoreUser.service.UserService;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserRepository repo;
	
	public void createAccount(User user) 
	{
	   repo.save(user); 	
	}
	public boolean isUserExist(String uid) 
	{
		return repo.existsById(uid);
	}
	public User getUser(String uid) 
	{
		User user=repo.findById(uid).orElse(null);
		return user;
	}
	public void updateUser(User user) 
	{
		   repo.save(user); 	
	}
	public void updatePassword(String pass, String uid)
	{
	    repo.updateUserPassword(pass,uid);
	}
	
}
