package org.Bank.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.springframework.stereotype.Component;


@Entity(name="WithdraOperation")
public class WithdraOperation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 20)
	private String bankName;
	@Column(length = 20)
	private String userName;
	@Column(length = 12)
	private String accountNumber;
	@Column(length = 8)
	private String ifsc;
	@Column
	private float withdraw;
	public WithdraOperation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WithdraOperation(int id, String bankName, String userName, String accountNumber, String ifsc, float withdraw) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.userName = userName;
		this.accountNumber = accountNumber;
		this.ifsc = ifsc;
		this.withdraw = withdraw;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public float getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(float withdraw) {
		this.withdraw = withdraw;
	}
	@Override
	public String toString() {
		return "WithdraOperation [id=" + id + ", bankName=" + bankName + ", userName=" + userName + ", accountNumber="
				+ accountNumber + ", ifsc=" + ifsc + ", withdraw=" + withdraw + "]";
	}
	
	
	

}
