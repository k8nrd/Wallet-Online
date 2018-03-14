package com.k8nrd.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.k8nrd.domains.NewUserDTO;
import com.k8nrd.domains.User;

public interface AppUserService extends UserDetailsService {
	User registerUser(NewUserDTO user);
}
