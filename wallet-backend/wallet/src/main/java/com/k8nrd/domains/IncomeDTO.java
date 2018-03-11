package com.k8nrd.domains;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

public class IncomeDTO {

	private IncomeCathegory cathegory;
	private boolean flag = true;
	private String info;
	private BigDecimal price;
	private GregorianCalendar date;
	public IncomeCathegory getCathegory() {
		return cathegory;
	}
	public void setCathegory(IncomeCathegory cathegory) {
		this.cathegory = cathegory;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
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
