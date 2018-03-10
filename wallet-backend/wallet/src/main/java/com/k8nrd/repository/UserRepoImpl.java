package com.k8nrd.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.k8nrd.domains.NewUserDTO;
import com.k8nrd.domains.Transaction;
import com.k8nrd.domains.User;

@Repository
@Transactional
public class UserRepoImpl implements UserRepository {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public User findOneByUsername(String username) {
		User u = new User();
		u.setUsername("wizzzy");
		u.setEnabled(true);
		u.setPassword(new BCryptPasswordEncoder().encode("siema"));
		u.setId(1L);
		return u;
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

	@Override
	public User registerUser(NewUserDTO user) {
		this.sf.getCurrentSession().persist(user);
		return null;
	}

}
