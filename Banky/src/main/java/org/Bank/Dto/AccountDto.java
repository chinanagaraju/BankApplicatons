package org.Bank.Dto;

import java.math.BigInteger;

public class AccountDto {
	private String userName;
	private String bankName;
	private String ifsc;
	private int id;
	private long mobile;
	private String location;
	private float balance;
	private  String accountNumber;

	
	public AccountDto() {
		// TODO Auto-generated constructor stub
	}
	
	public AccountDto(String userName, String bankName, String ifsc, int id, long mobile, String location, float balance,
			String accountNumber) {
		super();
		this.userName = userName;
		this.bankName = bankName;
		this.ifsc = ifsc;
		this.id = id;
		this.mobile = mobile;
		this.location = location;
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "AccountDto [userName=" + userName + ", bankName=" + bankName + ", ifsc=" + ifsc + ", id=" + id
				+ ", mobile=" + mobile + ", location=" + location + ", balance=" + balance + ", accountNumber="
				+ accountNumber + "]";
	}
	

	}
