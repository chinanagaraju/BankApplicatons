package org.Bank.Service;

import java.util.ArrayList;

import org.Bank.entity.Account;
import org.Bank.entity.WithdraOperation;
import org.Bank.Dto.AccountDto;
import org.Bank.Dto.Response;
import org.Bank.Dto.WithdrawOperationDto;

public interface BankService {
Response addBank(AccountDto  accountDto);
ArrayList<Account> getDetails();
Response addMoney(AccountDto accountDto);
Response accountToaccount(WithdrawOperationDto withdrawOperationDto,AccountDto accountDto);


}
