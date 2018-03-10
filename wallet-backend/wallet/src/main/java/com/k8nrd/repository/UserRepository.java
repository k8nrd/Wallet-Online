package com.k8nrd.repository;

import java.util.List;

import com.k8nrd.domains.NewUserDTO;
import com.k8nrd.domains.Transaction;
import com.k8nrd.domains.User;

public interface UserRepository {
	User findOneByUsername(String username);
	List<Transaction> getUserTransactionList(String username);
	Transaction addUserTransaction(String username, Transaction transaction);
	Transaction updateUserTransaction(String username, Transaction transaction);
	Transaction deleteUserTransaction(String username, long id);
	Transaction getTransaction(String username, long id);
	User registerUser(NewUserDTO user);
}
