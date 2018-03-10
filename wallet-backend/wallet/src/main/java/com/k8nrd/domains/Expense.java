package com.k8nrd.domains;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class Expense extends Transaction {
	
	private ExpenseCathegory expenseCathegory;

	public ExpenseCathegory getExpenseCathegory() {
		return expenseCathegory;
	}

	public void setExpenseCathegory(ExpenseCathegory expenseCathegory) {
		this.expenseCathegory = expenseCathegory;
	}
	
	
}
