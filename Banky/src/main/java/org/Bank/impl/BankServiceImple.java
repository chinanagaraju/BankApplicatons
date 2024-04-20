package org.Bank.impl;

import java.util.ArrayList;

import org.Bank.entity.Account;
import org.Bank.entity.Transfer;
import org.Bank.entity.WithdraOperation;
import org.Bank.Dto.AccountDto;
import org.Bank.Dto.Response;
import org.Bank.Dto.WithdrawOperationDto;
import org.Bank.Service.BankService;
import org.Bank.repo.BankRepo;
import org.Bank.repo.WithdrawRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImple implements BankService {

	@Autowired
	private BankRepo bankRepo;
	@Autowired
	private WithdrawRepo withdrawRepo;

	@Override
	public Response addBank(AccountDto accountDto) {
		if (accountDto == null) {
			return new Response("Account details are required.", true);
		}

		System.out.println("In service implementation");
		Account existingAccount = bankRepo.findByAccountNumber(accountDto.getAccountNumber());
		String ifscPattern = "^[A-Za-z]{3,4}[0-9]{5}$";
		String mobileStr = String.valueOf(accountDto.getMobile());
		String accountNumberStr = String.valueOf(accountDto.getAccountNumber());

		if (existingAccount != null) {
			if (accountDto.getUserName().equalsIgnoreCase(existingAccount.getUserName())
					&& accountDto.getIfsc().equalsIgnoreCase(existingAccount.getIfsc())
					&& existingAccount.getAccountNumber().equals(accountNumberStr)
					&& accountDto.getBankName().equalsIgnoreCase(existingAccount.getBankName())) {
				return new Response("User already has an account", false);
			}
		}

		if (accountDto.getUserName() == null || accountDto.getUserName().isEmpty() || accountDto.getBankName() == null
				|| accountDto.getBankName().isEmpty() || !accountDto.getIfsc().matches(ifscPattern)) {
			return new Response("Invalid IFSC code length 8, user name, or bank name.", false);
		}

		if (mobileStr.length() != 10) {
			return new Response("Mobile number must be 10 digits.", false);
		}

		if (accountNumberStr.length() != 12) {
			return new Response("Account number must be 12 digits.", false);
		}

		Account newAccount = new Account(accountDto.getId(), accountDto.getUserName(), accountDto.getMobile(),
				accountDto.getAccountNumber(), accountDto.getBalance(), accountDto.getBankName(),
				accountDto.getLocation(), accountDto.getIfsc());
		bankRepo.save(newAccount);
		return new Response("Account created successfully.", true);
	}

	@Override
	public ArrayList<Account> getDetails() {
		// TODO Auto-generated method stub
		System.out.println(bankRepo.findAll().toString());
		ArrayList<Account> accounts = (ArrayList<Account>) bankRepo.findAll();
		return accounts;
	}

	// TODO Auto-generated method stub
	public Response processAccount(AccountDto accountDto) {

		if (accountDto == null) {
			return new Response("Please fill in the required data", false);
		}

		if (isNullOrEmpty(accountDto.getBankName()) || isNullOrEmpty(accountDto.getUserName())) {
			return new Response("Please check bank name and username", false);
		}

		Account existed = bankRepo.findByAccountNumber(accountDto.getAccountNumber().toString());

		if (existed != null) {

			if (existed.getBankName().equalsIgnoreCase(accountDto.getBankName())
					&& existed.getUserName().equalsIgnoreCase(accountDto.getUserName())
					&& existed.getAccountNumber().equals(accountDto.getAccountNumber().toString())
					&& existed.getIfsc().equalsIgnoreCase(accountDto.getIfsc())) {
				float newBalance = existed.getBalance() + accountDto.getBalance();
				existed.setBalance(newBalance);
				bankRepo.save(existed);
				return new Response("Balance updated successfully", true);

			}
			return new Response("No matching account found with bankName" + " and userName: ", false);
		}

		return new Response("You don't have an account", false);

	}

	private boolean isNullOrEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	@Override
	public Response addMoney(AccountDto accountDto) {
		// TODO Auto-generated method stub
		return processAccount(accountDto);
	}

	@Override
	public Response accountToaccount(WithdrawOperationDto withdrawOperationDto, AccountDto accountDto) {
		// TODO Auto-generated method stub
		if (withdrawOperationDto == null) {
			return new Response(" withdrawOperationDto  feilds are requires", false);
		}
		if( accountDto == null) {
			return new Response(" AccountDto  feilds are requires", false);
			
		}
		Account fromAccount = bankRepo.findByAccountNumber(withdrawOperationDto.getAccountNumber().toString());
		Account toAccount = bankRepo.findByAccountNumber(accountDto.getAccountNumber().toString());
		if (fromAccount == null) {
			return new Response(" debit acount details required", false);
		}
		if (toAccount == null) {

			return new Response(" creadited account details required", false);
		}

		if (fromAccount.getBankName().equalsIgnoreCase(withdrawOperationDto.getBankName())
				&& fromAccount.getIfsc().equalsIgnoreCase(withdrawOperationDto.getIfsc())
				&& fromAccount.getAccountNumber().equals(withdrawOperationDto.getAccountNumber().toString())
				&& fromAccount.getUserName().equalsIgnoreCase(withdrawOperationDto.getUserName())) {

			if (toAccount.getBankName().equalsIgnoreCase(accountDto.getBankName())
					&& toAccount.getIfsc().equalsIgnoreCase(accountDto.getIfsc())
					&& toAccount.getAccountNumber().equals(accountDto.getAccountNumber().toString())
					&& toAccount.getUserName().equalsIgnoreCase(accountDto.getUserName())) {
              
				      if(fromAccount.getBalance()>0) {
				
				fromAccount.setBalance(fromAccount.getBalance() - withdrawOperationDto.getWithdraw());
				float deposit=withdrawOperationDto.getWithdraw();
				bankRepo.save(fromAccount);
				WithdraOperation withdraOperation = new WithdraOperation(fromAccount.getId(),
						withdrawOperationDto.getBankName(), withdrawOperationDto.getUserName(),
						withdrawOperationDto.getAccountNumber().toString(), withdrawOperationDto.getIfsc(),
						withdrawOperationDto.getWithdraw());
				withdrawRepo.save(withdraOperation);
				toAccount.setBalance(toAccount.getBalance() + deposit);
				bankRepo.save(toAccount);
				return new Response(withdraOperation.getWithdraw() +" "+ "amount withdraw from account"
						+ withdrawOperationDto.getAccountNumber()+" " + "and credited to acoount"
						+ toAccount.getAccountNumber(), true);
		                	}
				       else {
			return new Response("insufficient balance unable to perform withdraw ",false);	
			             }
				      }
		else {
				return new Response("created account not found", false);
			}
		}
		return new Response("debited account not found", false);

	}
}
