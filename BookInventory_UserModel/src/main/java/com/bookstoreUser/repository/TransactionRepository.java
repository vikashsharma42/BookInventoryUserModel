package com.bookstoreUser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstoreUser.models.UserTransaction;

public interface TransactionRepository extends JpaRepository<UserTransaction,Integer> 
{
     List<UserTransaction>findByuserid(String userid);
}
