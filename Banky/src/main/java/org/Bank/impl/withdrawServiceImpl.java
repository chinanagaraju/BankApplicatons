package org.Bank.impl;

import org.Bank.entity.Account;
import org.Bank.entity.WithdraOperation;

import java.util.ArrayList;
import java.util.List;

import org.Bank.Dto.Response;
import org.Bank.Dto.WithdrawOperationDto;
import org.Bank.Service.WithdrawService;
import org.Bank.repo.BankRepo;
import org.Bank.repo.WithdrawRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class withdrawServiceImpl implements WithdrawService {

	@Autowired
	private BankRepo bankRepo;
	@Autowired
	private WithdrawRepo withdrawRepo;

	public Response withdrawMoneys(WithdrawOperationDto withdrawOperationDto) {
		if (withdrawOperationDto == null) {
			return new Response("Invalid request: withdrawOperationDto is null", false);
		}
		try {
			String accountNumber=withdrawOperationDto.getAccountNumber().toString();
			Account acco = bankRepo.findByAccountNumber(accountNumber);
			if (acco != null) {
				if (acco.getBankName().equalsIgnoreCase(withdrawOperationDto.getBankName())
						&& acco.getAccountNumber().equals(withdrawOperationDto.getAccountNumber())
						&& acco.getIfsc().equalsIgnoreCase(withdrawOperationDto.getIfsc())
						&& acco.getUserName().equalsIgnoreCase(withdrawOperationDto.getUserName())) {
					float amountToWithdraw = withdrawOperationDto.getWithdraw();
					float newBalance = acco.getBalance() - amountToWithdraw;

					if (newBalance < 0) {
						return new Response("Insufficient balance for withdrawal", false);
					}
					acco.setBalance(newBalance);
					bankRepo.save(acco);
					WithdraOperation withdraOperation=new WithdraOperation( acco.getId(),withdrawOperationDto.getBankName(),withdrawOperationDto.getUserName(),withdrawOperationDto.getAccountNumber(),withdrawOperationDto.getIfsc(),withdrawOperationDto.getWithdraw());
					withdrawRepo.save(withdraOperation);
					return new Response("amount"+withdrawOperationDto.getWithdraw()+"successfully withdrawn", true);

				}
				return new Response("Check details again", false);
			}
			return new Response("you don't have account", false);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new Response("create account then try again", false);
	}

	@Override
	public Response withdrawMoney(WithdrawOperationDto withdrawOperationDto) {
		// TODO Auto-generated method stub
		return withdrawMoneys(withdrawOperationDto);
	}
}
