package org.Bank.entity;

import java.math.BigInteger;

public class Transfer {
	
	private String  account;
	private String userName;
	private String bankName;

	private String ifsc;
	 
	public Transfer() {
		// TODO Auto-generated constructor stub
	}

	public Transfer(String account, String userName, String bankName, String ifsc) {
		super();
		this.account = account;
		this.userName = userName;
		this.bankName = bankName;
		
		this.ifsc = ifsc;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	@Override
	public String toString() {
		return "Transfer [account=" + account + ", userName=" + userName + ", bankName=" + bankName + ", ifsc=" + ifsc
				+ "]";
	}
      
	
	
	
	
 
}
