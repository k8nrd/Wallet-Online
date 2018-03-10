package com.k8nrd.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.k8nrd.domains.Expense;
import com.k8nrd.domains.Income;
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
		return null;
	}
	
	@GetMapping("/transaction")
	public ResponseEntity<Transaction> getTransaction(Principal prini){
		if(prini != null){
			System.out.println(prini.getName());
		}
		return new ResponseEntity<Transaction>(new Income(), HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public String register() {
		return "siema";
	}
}
