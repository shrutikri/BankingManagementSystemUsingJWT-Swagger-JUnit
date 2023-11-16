package com.fis.bankingmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Accounts {
	@Id
	//@Min(value = 6, message = "Account Number Cannot be less than 6")
	//@Max(value = 10, message = "Account Number cannot be greater than 10") // MANVE
	private int accNo;
	@NotBlank(message="Customer name is mandatory!")
	private String custName;
	private int balance;
	private String acctStatus;

	public int getAccNo() {
		return accNo;
	}

	public int setAccNo(int accNo) {
		return this.accNo = accNo;
	}

	public int getBalance() {
		return balance;
	}

	public int setBalance(int balance) {
		return this.balance = balance;
	}

	public String getAcctStatus() {
		return acctStatus;
	}

	public String setAcctStatus(String acctStatus) {
		return this.acctStatus = acctStatus;
	}
	

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Override
	public String toString() {
		return "Accounts [accNo=" + accNo + ", custName=" + custName + ", balance=" + balance + ", acctStatus="
				+ acctStatus + "]";
	}
	

	public Accounts(int accNo, @NotBlank(message = "Customer name is mandatory!") String custName, int balance,
			String acctStatus) {
		super();
		this.accNo = accNo;
		this.custName = custName;
		this.balance = balance;
		this.acctStatus = acctStatus;
	}

	public Accounts() {
	}

}
