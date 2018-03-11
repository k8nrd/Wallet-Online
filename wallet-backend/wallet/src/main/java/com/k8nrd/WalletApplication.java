package com.k8nrd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.k8nrd.domains.User;
import com.k8nrd.repository.UserRepository;



@SpringBootApplication
@EnableResourceServer
public class WalletApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(WalletApplication.class, args);
	}
}
