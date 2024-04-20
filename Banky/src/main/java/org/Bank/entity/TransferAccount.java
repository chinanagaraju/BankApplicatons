package org.Bank.entity;

import org.Bank.Dto.AccountDto;
import org.Bank.Dto.WithdrawOperationDto;

public class TransferAccount {
	 private AccountDto accountDto;
	 private WithdrawOperationDto withdrawOperationDto;
	 
	 
	 
	public TransferAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TransferAccount(AccountDto accountDto, WithdrawOperationDto withdrawOperationDto) {
		super();
		this.accountDto = accountDto;
		this.withdrawOperationDto = withdrawOperationDto;
	}

	public AccountDto getAccountDto() {
		return accountDto;
	}
	public void setAccountDto(AccountDto accountDto) {
		this.accountDto = accountDto;
	}
	public WithdrawOperationDto getWithdrawOperationDto() {
		return withdrawOperationDto;
	}
	public void setWithdrawOperationDto(WithdrawOperationDto withdrawOperationDto) {
		this.withdrawOperationDto = withdrawOperationDto;
	}
	 

}
