package com.k8nrd.domains;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class Expense extends Transaction {
	
	private ExpenseCathegory cathegory;
	private boolean flag = false;

	public ExpenseCathegory getCathegory() {
		return cathegory;
	}

	public void setCathegory(ExpenseCathegory cathegory) {
		this.cathegory = cathegory;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	
	
	
	
}
