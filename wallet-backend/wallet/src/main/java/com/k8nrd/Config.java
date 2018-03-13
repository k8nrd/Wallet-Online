package com.k8nrd;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class Config extends WebSecurityConfigurerAdapter {
	
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
		return hemf.getSessionFactory();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			   
		    http.antMatcher("/register")
	        .authorizeRequests()
	        .antMatchers("/register")
	        .permitAll().and().csrf().disable();
		        
		
	}
	
	

}
