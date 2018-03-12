package com.k8nrd.repository;

import java.util.List;

import javax.transaction.UserTransaction;

import com.k8nrd.domains.ExpenseDTO;
import com.k8nrd.domains.IncomeDTO;
import com.k8nrd.domains.NewUserDTO;
import com.k8nrd.domains.Transaction;
import com.k8nrd.domains.User;
import com.k8nrd.domains.UserTransactions;

public interface UserRepository {
	User findOneByUsername(String username);
	List<Transaction> getUserTransactionList(String username);
	Transaction addUserTransactionIncome(String username, IncomeDTO transaction);
	Transaction addUserTransactionExpense(String username, ExpenseDTO transaction);
	Transaction updateUserTransaction(String username, Transaction transaction);
	Transaction deleteUserTransaction(String username, long id);
	Transaction getTransaction(String username, long id);
	User registerUser(NewUserDTO user);
	UserTransactions getUserDetailsTransaction(String username);
}
