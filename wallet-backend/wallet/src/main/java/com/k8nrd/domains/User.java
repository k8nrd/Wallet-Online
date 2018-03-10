package com.k8nrd.domains;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name = "users")
public class User implements UserDetails {
	
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false, updatable = false)
	private Long id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Transaction> userTransactions;
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// we never lock accounts
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// credentials never expire
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public List<Transaction> getUserTransactions() {
		return userTransactions;
	}

	public void setUserTransactions(List<Transaction> userTransactions) {
		this.userTransactions = userTransactions;
	}
	
	

}