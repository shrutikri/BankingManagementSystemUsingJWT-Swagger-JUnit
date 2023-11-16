package com.fis.bankingmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Transaction {
	@Id
	private int accNo;
	private String typeOfTransaction;
	private String statusOfTransaction;
	private int prevBal;
	private int newBal;

	public int getAccNo() {
		return accNo;
	}

	public int setAccNo(int accNo) {
		return this.accNo = accNo;
	}

	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}

	public String setTypeOfTransaction(String typeOfTransaction) {
		return this.typeOfTransaction = typeOfTransaction;
	}

	public String getStatusOfTransaction() {
		return statusOfTransaction;
	}

	public String setStatusOfTransaction(String statusOfTransaction) {
		return this.statusOfTransaction = statusOfTransaction;
	}

	public int getPrevBal() {
		return prevBal;
	}

	public void setPrevBal(int prevBal) {
		this.prevBal = prevBal;
	}

	public int getNewBal() {
		return newBal;
	}

	public void setNewBal(int newBal) {
		this.newBal = newBal;
	}

	@Override
	public String toString() {
		return "Transaction [accNo=" + accNo + ", typeOfTransaction=" + typeOfTransaction + ", statusOfTransaction="
				+ statusOfTransaction + ", prevBal=" + prevBal + ", newBal=" + newBal + "]";
	}

	public Transaction(int accNo, String typeOfTransaction, String statusOfTransaction, int prevBal, int newBal) {
		super();
		this.accNo = accNo;
		this.typeOfTransaction = typeOfTransaction;
		this.statusOfTransaction = statusOfTransaction;
		this.prevBal = prevBal;
		this.newBal = newBal;
	}

	public Transaction() {

	}

}
