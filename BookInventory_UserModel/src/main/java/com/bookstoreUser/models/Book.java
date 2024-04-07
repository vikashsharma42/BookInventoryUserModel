package com.bookstoreUser.models;

import jakarta.persistence.*;

@Entity
public class Book
{
	@Id
	@GeneratedValue(generator="book_seq")
	@SequenceGenerator(name="book_seq",initialValue = 2251,allocationSize = 1)
        private int bid;
	private String author;
	private int catid;
	private int copies;
	private int price;
	private int pubid;
	private String title;
	public int getBid()
	{
		return bid;
	}
	public void setBid(int bid) 
	{
		this.bid = bid;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author) 
	{
		this.author = author;
	}
	public int getCatid()
	{
		return catid;
	}
	public void setCatid(int catid)
	{
		this.catid = catid;
	}
	public int getCopies() 
	{
		return copies;
	}
	public void setCopies(int copies)
	{
		this.copies = copies;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public int getPubid() 
	{
		return pubid;
	}
	public void setPublisherid(int pubid)
	{
		this.pubid = pubid;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}  
}
