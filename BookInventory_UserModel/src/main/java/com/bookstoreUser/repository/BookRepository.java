package com.bookstoreUser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.bookstoreUser.models.Book;

import jakarta.transaction.Transactional;

public interface BookRepository extends JpaRepository<Book,Integer>
{
	List<Book>findByBid(int bid);
	List<Book>findByAuthor(String author);
	List<Book>findByTitle(String title);
	List<Book>findByCatid(int catid);
	List<Book>findByPubid(int pubid);
	
	@Modifying
	@Transactional
    @Query("update Book set copies=copies-:c where bid=:b")
	void updateBookQuantity(@Param("c") int quantity,@Param("b") int bid);
}
