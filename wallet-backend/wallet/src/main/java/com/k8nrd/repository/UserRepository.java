package com.k8nrd.repository;

import com.k8nrd.domains.User;

public interface UserRepository {
	User findOneByUsername(String username);
}
