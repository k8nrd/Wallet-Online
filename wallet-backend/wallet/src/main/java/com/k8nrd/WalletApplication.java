package com.k8nrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;





@SpringBootApplication
@EnableResourceServer
public class WalletApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(WalletApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WalletApplication.class, args);
	}
}
