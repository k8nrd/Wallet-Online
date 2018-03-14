package com.k8nrd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.k8nrd.domains.NewUserDTO;
import com.k8nrd.domains.User;
import com.k8nrd.repository.UserRepository;

@Service("userDetailsService")
public class UserService implements AppUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findOneByUsername(username);
	}

	@Override
	public User registerUser(NewUserDTO user) {
		return this.userRepository.registerUser(user);
	}
}