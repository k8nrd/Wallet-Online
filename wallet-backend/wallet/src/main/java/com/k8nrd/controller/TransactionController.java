package com.k8nrd.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.k8nrd.domains.Expense;
import com.k8nrd.domains.Income;
import com.k8nrd.domains.Transaction;

@RestController
public class TransactionController {

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
	
	@GetMapping("/transaction/{id}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable String id, Principal principle){
		return null;
	}
}
