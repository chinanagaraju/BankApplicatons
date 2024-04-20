package org.Bank.Dto;

import java.math.BigInteger;

public class LoginDto {
 private int id;
 private String userName;
 private String password;
 private String accountNumber;
 private String bankname;
 private String ifsc;
 
 
public LoginDto() {
	super();
	// TODO Auto-generated constructor stub
}


public LoginDto(int id, String userName, String password, String accountNumber, String bankname,String ifsc) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.accountNumber = accountNumber;
	this.bankname = bankname;
	this.ifsc=ifsc;
}





public int getId() {
	return id;
}





public void setId(int id) {
	this.id = id;
}





public String getUserName() {
	return userName;
}





public void setUserName(String userName) {
	this.userName = userName;
}





public String getPassword() {
	return password;
}





public void setPassword(String password) {
	this.password = password;
}





public String getAccountNumber() {
	return accountNumber;
}





public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}





public String getBankName() {
	return bankname;
}





public void setBankName(String bankname) {
	this.bankname = bankname;
}


public String getIfsc() {
	return ifsc;
}


public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
}


}
