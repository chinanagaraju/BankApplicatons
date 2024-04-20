package org.Bank.Dto;

import java.math.BigInteger;

public class WithdrawOperationDto {

	
		private int id;
	
		private String bankName;
		private String userName;
	
		private String accountNumber;
	
		private String ifsc;
	
		private float withdraw;
			
		public WithdrawOperationDto() {
			super();
			// TODO Auto-generated constructor stub
		}
	
		
		public WithdrawOperationDto(int id, String bankName, String userName, String accountNumber, String ifsc,
				float withdraw) {
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



