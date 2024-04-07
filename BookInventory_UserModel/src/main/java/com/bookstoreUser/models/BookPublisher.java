package com.bookstoreUser.models;

import jakarta.persistence.*;

@Entity
public class BookPublisher 
{
	@Id
	@GeneratedValue(generator="pub_seq")
	@SequenceGenerator(name="pub_seq",initialValue = 2201,allocationSize = 1)
    private int pubid;
	private String publisher;
	private String address;
	private String email;
	
	public int getPubid() 
	{
		return pubid;
	}
	public void setPubid(int pubid)
	{
		this.pubid = pubid;
	}
	public String getPublisher() 
	{
		return publisher;
	}
	public void setPublisher(String publisher) 
	{
		this.publisher = publisher;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}	
}
