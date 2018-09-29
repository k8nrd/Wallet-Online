package com.k8nrd.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.k8nrd.domains.Expense;
import com.k8nrd.domains.ExpenseDTO;
import com.k8nrd.domains.Income;
import com.k8nrd.domains.IncomeDTO;
import com.k8nrd.domains.NewUserDTO;
import com.k8nrd.domains.Transaction;
import com.k8nrd.exception.NotFoundException;
import com.k8nrd.services.AppUserService;
import com.k8nrd.services.TransactionService;


@RestController
public class TransactionController {
	
	Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	private TransactionService ur;
	
	@Autowired
	private AppUserService us;
	
	
	@PostMapping("/add/income")
	public ResponseEntity<Income> saveIncome(@RequestBody IncomeDTO income, Principal prinicpal){
		logger.info("/add/income" + "request");
		this.ur.addUserTransactionIncome(prinicpal.getName(), income);
		return new ResponseEntity<Income>(HttpStatus.OK);
	}
	
	@PostMapping("/add/expense")
	public ResponseEntity<Expense> saveIncome(@RequestBody ExpenseDTO expense, Principal prinicpal){
		logger.info("/add/expense" + "request");
		this.ur.addUserTransactionExpense(prinicpal.getName(), expense);
		return new ResponseEntity<Expense>(HttpStatus.OK);
	}
	
	@GetMapping("/list/all")
	public ResponseEntity<List<Transaction>> getAllList(Principal prinicpal) {
		logger.info("/list/all" + "request");
		return new ResponseEntity<List<Transaction>>(this.ur.getUserTransactionList(prinicpal.getName()), HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Boolean> register(@RequestBody NewUserDTO newUser) {
		logger.info("/register" + "request, by:" + newUser.getUsername());
		if(this.us.loadUserByUsername(newUser.getUsername()) == null){
			this.us.registerUser(newUser);
			return new ResponseEntity<>(true, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(false,HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/delete/trans/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable int id, Principal principal) throws NotFoundException{
		logger.info("/delete/trans/"+id + "request");
		if(this.ur.deleteUserTransaction(principal.getName(), id)==null){
			throw new NotFoundException();
		};
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
	}
	
	
	
}
