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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cathegory == null) ? 0 : cathegory.hashCode());
		result = prime * result + (flag ? 1231 : 1237);
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncomeDTO other = (IncomeDTO) obj;
		if (cathegory != other.cathegory)
			return false;
		if (flag != other.flag)
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	
	
}
