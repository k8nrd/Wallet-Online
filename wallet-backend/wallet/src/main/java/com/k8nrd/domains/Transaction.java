package com.k8nrd.domains;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Entity
@Inheritance
public abstract class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String info;
	private BigDecimal price;
	private GregorianCalendar date;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public GregorianCalendar getDate() {
		return date;
	}
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	
	
	
}
