package com.k8nrd.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.k8nrd.domains.Expense;
import com.k8nrd.domains.ExpenseCathegory;
import com.k8nrd.domains.Income;
import com.k8nrd.domains.IncomeCathegory;
import com.k8nrd.domains.NewUserDTO;
import com.k8nrd.domains.Transaction;
import com.k8nrd.domains.User;
import com.k8nrd.repository.UserRepository;

@RestController
public class TransactionController {

	@Autowired
	UserRepository ur;
	
	
	@PostMapping("/add/income")
	public ResponseEntity<Income> saveIncome(@RequestBody Income income, Principal prinicpal){
		return null;
	}
	
	@PostMapping("/add/expense")
	public ResponseEntity<Expense> saveIncome(@RequestBody Expense expense, Principal prinicpal){
		return null;
	}
	
	@GetMapping("/list/all")
	public ResponseEntity<List<Transaction>> getAllList(Principal prinicpal) {
		List<Transaction> ls = new ArrayList<Transaction>();
		Income in = new Income();
		in.setDate(new GregorianCalendar());
		in.setCathegory(IncomeCathegory.SALARY);
		in.setInfo(prinicpal.getName());
		in.setPrice(new BigDecimal(10000));
		ls.add(in);
		Expense in2 = new Expense();
		in2.setDate(new GregorianCalendar());
		in2.setCathegory(ExpenseCathegory.CLOTHES);
		in2.setInfo(prinicpal.getName());
		in2.setPrice(new BigDecimal(10000));
		ls.add(in2);
		return new ResponseEntity<List<Transaction>>(ls, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public String register(@RequestBody NewUserDTO newUser) {
		return "siema";
	}
}
