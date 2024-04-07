package com.bookstoreUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstoreUser.models.BookPublisher;

public interface PublisherRepository extends JpaRepository<BookPublisher,Integer>
{
}
