package com.k8nrd.services;

import java.util.List;

import com.k8nrd.domains.ExpenseDTO;
import com.k8nrd.domains.IncomeDTO;
import com.k8nrd.domains.Transaction;
import com.k8nrd.domains.UserTransactions;

public interface TransactionService {
	List<Transaction> getUserTransactionList(String username);
	Transaction addUserTransactionIncome(String username, IncomeDTO transaction);
	Transaction addUserTransactionExpense(String username, ExpenseDTO transaction);
	Transaction deleteUserTransaction(String username, long id);
	UserTransactions getUserDetailsTransaction(String username);
}
