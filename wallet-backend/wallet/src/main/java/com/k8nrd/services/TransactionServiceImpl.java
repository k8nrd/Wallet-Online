package com.k8nrd.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.k8nrd.controller.TransactionController;
import com.k8nrd.domains.ExpenseDTO;
import com.k8nrd.domains.IncomeDTO;
import com.k8nrd.domains.Transaction;
import com.k8nrd.domains.UserTransactions;
import com.k8nrd.repository.UserRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	
	@Autowired
	private UserRepository ur;
	
	@Override
	public List<Transaction> getUserTransactionList(String username) {
		logger.info("getUserTransactionList: " + username);
		return this.ur.getUserTransactionList(username);
	}

	@Override
	public Transaction addUserTransactionIncome(String username, IncomeDTO transaction) {
		logger.info("addUserTransactionIncome: " + username);
		return this.ur.addUserTransactionIncome(username, transaction);
	}

	@Override
	public Transaction addUserTransactionExpense(String username, ExpenseDTO transaction) {
		logger.info("addUserTransactionExpense: " + username);
		return this.ur.addUserTransactionExpense(username, transaction);
	}

	@Override
	public Transaction deleteUserTransaction(String username, long id) {
		logger.info("deleteUserTransaction: " + username);
		return this.ur.deleteUserTransaction(username, id);
	}

	@Override
	public UserTransactions getUserDetailsTransaction(String username) {
		logger.info("getUserDetailsTransaction: " + username);
		return this.ur.getUserDetailsTransaction(username);
	}

}
