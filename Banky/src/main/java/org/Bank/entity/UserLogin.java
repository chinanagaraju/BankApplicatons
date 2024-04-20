package org.Bank.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserLogin {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 20)
 private String userName;
	@Column(length = 12)
 private String password;
	@Column(length = 12)
 private String accountNumber;
	@Column
	private String bankName;
	@Column
	private String ifsc;
	
	
	


	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	





	public UserLogin(int id, String userName, String password, String accountNumber, String bankName, String ifsc) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.ifsc = ifsc;
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
		return "UserLogin [id=" + id + ", userName=" + userName + ", password=" + password + ", accountNumber="
				+ accountNumber + ", bankName=" + bankName + ", ifsc=" + ifsc + "]";
	}
}





	