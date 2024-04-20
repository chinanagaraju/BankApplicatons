package org.Bank.entity;



import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@Column
	private String userName;
	@Column(length = 10)
	private long mobile;
	@Column(length = 12)
	private String accountNumber;
	@Column
	private float balance;
	@Column
	private String bankName;
	@Column
	private String location;
	@Column(length = 9)
	private String ifsc;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int id, String userName, long mobile, String accountNumber, float balance, String bankName,
			String location, String ifsc) {
		super();
		Id = id;
		this.userName = userName;
		this.mobile = mobile;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.bankName = bankName;
		this.location = location;
		this.ifsc = ifsc;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	@Override
	public String toString() {
		return "Account [Id=" + Id + ", userName=" + userName + ", mobile=" + mobile + ", accountNumber="
				+ accountNumber + ", balance=" + balance + ", bankName=" + bankName + ", location=" + location
				+ ", ifsc=" + ifsc + "]";
	}


	
	

}
