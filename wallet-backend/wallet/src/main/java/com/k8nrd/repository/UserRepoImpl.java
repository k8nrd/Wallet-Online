package com.k8nrd.repository;

import java.util.ArrayList;
import java.util.GregorianCalendar;
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

import com.k8nrd.domains.Expense;
import com.k8nrd.domains.ExpenseDTO;
import com.k8nrd.domains.Income;
import com.k8nrd.domains.IncomeDTO;
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
	public Transaction updateUserTransaction(String username, Transaction transaction) {
		//UserTransactions ut = this.getUserDetailsTransaction(username);
		return null;
	}

	@Override
	public Transaction deleteUserTransaction(String username, long id) {
		UserTransactions ut = this.getUserDetailsTransaction(username);
		int index = 0;
		int iter = 0;
		for(Transaction t : ut.getTransactionList()){
			if(t.getId() == id){
				index = iter;
			}
			iter++;
		}
		return ut.getTransactionList().remove(index);
	}

	@Override
	public Transaction getTransaction(String username, long id) {
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

	@Override
	public Transaction addUserTransactionIncome(String username, IncomeDTO transaction) {
		UserTransactions ut = this.getUserDetailsTransaction(username);
		Income i = new Income();
		i.setCathegory(transaction.getCathegory());
		i.setDate(transaction.getDate());
		i.setFlag(true);
		i.setInfo(transaction.getInfo());
		i.setPrice(transaction.getPrice());
		ut.getTransactionList().add(i);
		return i;
	}

	@Override
	public Transaction addUserTransactionExpense(String username, ExpenseDTO transaction) {
		UserTransactions ut = this.getUserDetailsTransaction(username);
		Expense i = new Expense();
		i.setCathegory(transaction.getCathegory());
		i.setDate(transaction.getDate());
		i.setFlag(true);
		i.setInfo(transaction.getInfo());
		i.setPrice(transaction.getPrice());
		ut.getTransactionList().add(i);
		return i;
	}

}
