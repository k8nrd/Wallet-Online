package com.k8nrd.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.k8nrd.domains.Transaction;
import com.k8nrd.domains.User;

@Repository
public class UserRepoImpl implements UserRepository {

	@Override
	public User findOneByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getUserTransactionList(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction addUserTransaction(String username, Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction updateUserTransaction(String username, Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction deleteUserTransaction(String username, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction getTransaction(String username, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
