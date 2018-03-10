package com.k8nrd.domains;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("I")
public class Income extends Transaction {

	private IncomeCathegory incomeCathegory;

	public IncomeCathegory getIncomeCathegory() {
		return incomeCathegory;
	}

	public void setIncomeCathegory(IncomeCathegory incomeCathegory) {
		this.incomeCathegory = incomeCathegory;
	}
	
	
}
