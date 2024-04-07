package com.bookstoreUser.service;

import com.bookstoreUser.models.User;

public interface UserService 
{

	void createAccount(User user);
	boolean isUserExist(String uid);
	User getUser(String uid);
	void updateUser(User user);
	void updatePassword(String pass, String uid);
}
