package com.bookstoreUser.controller;

import java.time.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstoreUser.models.Book;
import com.bookstoreUser.models.UserTransaction;
import com.bookstoreUser.service.BookService;
import com.bookstoreUser.service.TransactionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("bookstore/user")
public class PurchaseController 
{
	@Autowired
	private BookService bookservice;
	@Autowired
	private TransactionService tservice;
	private Book book;
	
	@RequestMapping("purchase")
	public String purchaseNow(Model model,int bid)
	{
		book=bookservice.getBook(bid);
		model.addAttribute("book",book);
		return "purchase/purchase-now";
	}
	@RequestMapping("purchasenow")
	public String getPurchaseView(Model model,int quantity,HttpSession ses)
	{
		UserTransaction ut=new UserTransaction();
		ut.setUserid((String)ses.getAttribute("userid"));
		ut.setBid(book.getBid());
		ut.setQuantity(quantity);
		ut.setPrice(book.getPrice());
		ut.setDate(LocalDate.now().toString());
	    ut.setTime(LocalTime.now().toString());
		tservice.saveTranaction(ut);
		bookservice.updateQuantity(quantity,book.getBid());
		return "purchase/buy";
	}
	@RequestMapping("purchaseview-transaction")
	public String getTransactionList(Model model,HttpSession ses)
	{
		List<UserTransaction> list=tservice.getlist((String)ses.getAttribute("userid"));
		model.addAttribute("list",list);
		return "purchase/transaction-list";
	}
}
