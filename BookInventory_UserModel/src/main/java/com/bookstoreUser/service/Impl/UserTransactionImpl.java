package com.bookstoreUser.service.Impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreUser.models.UserTransaction;
import com.bookstoreUser.repository.TransactionRepository;
import com.bookstoreUser.service.TransactionService;

@Service
public class UserTransactionImpl implements TransactionService
{
    @Autowired
    private TransactionRepository trepo;

	public void saveTranaction(UserTransaction ut)
	{
		trepo.save(ut);
	}
	public List<UserTransaction> getlist(String userid)
	{
		return trepo.findByuserid(userid);
	}
}
