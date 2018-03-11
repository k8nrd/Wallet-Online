package com.k8nrd.domains;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("I")
public class Income extends Transaction {

	private IncomeCathegory cathegory;
	private boolean flag = true;

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

	
	
	
}
