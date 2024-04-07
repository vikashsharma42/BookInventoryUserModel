package com.bookstoreUser.service;

import java.util.List;

import com.bookstoreUser.models.UserTransaction;

public interface TransactionService 
{

	void saveTranaction(UserTransaction ut);

	List<UserTransaction> getlist(String attribute);

}
