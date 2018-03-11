package com.k8nrd.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.k8nrd.domains.NewUserDTO;
import com.k8nrd.domains.Transaction;
import com.k8nrd.domains.User;
import com.k8nrd.domains.UserTransactions;

@Repository
@Transactional
public class UserRepoImpl implements UserRepository {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public User findOneByUsername(String username) {
		//User u = new User();
		//u.setUsername("wizzzy");
		//u.setEnabled(true);
		//u.setPassword(new BCryptPasswordEncoder().encode("siema"));
	//	u.setId(1L);
		
		Criteria c = this.sf.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("username", username));
		List<User> ut = c.list();
		if(ut.size() == 0){
			return null;
		}else {
			return ut.get(0);
		}
	}

	@Override
	public List<Transaction> getUserTransactionList(String username) {
		UserTransactions ut = this.getUserDetailsTransaction(username);
		if(ut != null){
			return ut.getTransactionList();
		}else
		{
			return null;
		}
		 
	}

	@Override
	public Transaction addUserTransaction(String username, Transaction transaction) {
		
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
		User u = new User();
		u.setEnabled(true);
		u.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		u.setUsername(user.getUsername());
		UserTransactions ut = new UserTransactions();
		ut.setUsername(user.getUsername());
		ut.setTransactionList(new ArrayList<Transaction>());
		this.sf.getCurrentSession().persist(u);
		this.sf.getCurrentSession().persist(ut);
		return u;
	}

	@Override
	public UserTransactions getUserDetailsTransaction(String username) {
		Criteria c = sf.getCurrentSession().createCriteria(UserTransactions.class);
		c.add(Restrictions.eq("username", username));
		List<UserTransactions> ut = c.list();
		System.out.println(ut.size() + ut.toString());
		if(ut.size() == 0){
			return null;
		}else {
			return ut.get(0);
		}
	}

}
