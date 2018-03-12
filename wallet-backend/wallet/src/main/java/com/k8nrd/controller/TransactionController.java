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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.k8nrd.domains.Expense;
import com.k8nrd.domains.ExpenseCathegory;
import com.k8nrd.domains.ExpenseDTO;
import com.k8nrd.domains.Income;
import com.k8nrd.domains.IncomeCathegory;
import com.k8nrd.domains.IncomeDTO;
import com.k8nrd.domains.NewUserDTO;
import com.k8nrd.domains.Transaction;
import com.k8nrd.domains.User;
import com.k8nrd.repository.UserRepository;


@RestController
public class TransactionController {

	@Autowired
	private UserRepository ur;
	
	
	@PostMapping("/add/income")
	public ResponseEntity<Income> saveIncome(@RequestBody IncomeDTO income, Principal prinicpal) throws JsonProcessingException{
		this.ur.addUserTransactionIncome(prinicpal.getName(), income);
		System.out.println("ok1");
		return new ResponseEntity<Income>(HttpStatus.OK);
	}
	
	@PostMapping("/add/expense")
	public ResponseEntity<Expense> saveIncome(@RequestBody ExpenseDTO expense, Principal prinicpal){
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json;
		try {
			json = ow.writeValueAsString(expense);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<Expense>(HttpStatus.CONFLICT);
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
		
		for(int x=0; x< 12; x++){
			ls.add(in2);
			ls.add(in);
		}
		return new ResponseEntity<List<Transaction>>(ls, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Boolean> register(@RequestBody NewUserDTO newUser) {
		if(this.ur.findOneByUsername(newUser.getUsername()) == null){
			this.ur.registerUser(newUser);
			return new ResponseEntity<>(true, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(false,HttpStatus.CONFLICT);
		}
	}
	
}
