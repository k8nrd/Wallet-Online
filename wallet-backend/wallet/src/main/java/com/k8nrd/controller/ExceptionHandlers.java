package com.k8nrd.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionHandlers {
	
	Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleError(HttpServletRequest req, Exception ex) {
		String error = req.getRequestURL() + " raised " + ex;
		logger.error(error);
		return new ResponseEntity<String>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(HibernateException.class)
	public ResponseEntity<String> handleDBError(HttpServletRequest req, Exception ex) {
		String error = "Hibernate throws: " + ex.getMessage();
		logger.error(error);
		return new ResponseEntity<String>(error, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
}
