package com.k8nrd.domains;

import java.util.List;

public interface UserDetails extends org.springframework.security.core.userdetails.UserDetails {
	List<Transaction> getUserTransactions();
	void setUserTransactions(List<Transaction> userTransactions);
}
