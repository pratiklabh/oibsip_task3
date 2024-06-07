package com.model;

public class Transaction {

	private String accountName;
	private int accountNumber;
	private int amount;
	private String remarks;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "\nTransaction [Account Name = " + accountName + ", Account Number = " + accountNumber + ", Amount = " + amount
				+ ", Remarks = " + remarks + "]\n";
	}

}
