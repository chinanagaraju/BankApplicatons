package org.Bank.RestApi;

import java.util.ArrayList;

import org.Bank.entity.Account;
import org.Bank.entity.TransferAccount;
import org.Bank.entity.UserLogin;
import org.Bank.Dto.AccountDto;
import org.Bank.Dto.LoginDto;
import org.Bank.Dto.Response;
import org.Bank.Dto.WithdrawOperationDto;
import org.Bank.impl.BankServiceImple;
import org.Bank.impl.LoginServiceImpl;
import org.Bank.impl.withdrawServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("Bank")
public class BankRestControler {

@Autowired
	private  BankServiceImple bankServiceImple;
@Autowired
private withdrawServiceImpl withdrawServiceImpl;
@Autowired
private	 LoginServiceImpl loginServiceImpl;

	@PostMapping("account")
	public Response AddAccount( @RequestBody AccountDto accountDto) {
		System.out.println("in con");
		 return bankServiceImple.addBank(accountDto);
	}
     @GetMapping("getDetails")
	public ArrayList<Account> getDetails() {
    	 return bankServiceImple.getDetails();		
	}
     @PutMapping("Deposit")
     public Response AddMoney( @RequestBody AccountDto accountDto) {
    	 return bankServiceImple.addMoney(accountDto);
    	 
     }
     @PutMapping("withdraw")
     public Response WithdrawMoney(@RequestBody WithdrawOperationDto withdrawOperationDto) {
      return withdrawServiceImpl.withdrawMoney(withdrawOperationDto);
     }
     @PostMapping("user")
      public Response AddUser(@RequestBody LoginDto  loginDto) {
    	 return loginServiceImpl.addUser(loginDto);    	  
      }
     @PostMapping("login")
     public Response LoginOp(@RequestBody LoginDto loginDto) {
    	 return loginServiceImpl.loginOp(loginDto);
    	 
     }
     @GetMapping("getUser")
     public ArrayList<UserLogin> getUser() {
    	 return loginServiceImpl.getAll();
     }
     @PutMapping("transfer")
     public Response transferAccount(@RequestBody TransferAccount transferAccount) {
    	 WithdrawOperationDto withdrawOperationDto=transferAccount.getWithdrawOperationDto();
    	 AccountDto accountDto=transferAccount.getAccountDto();
    	 System.out.println(withdrawOperationDto+"F"+accountDto);
    	 return bankServiceImple.accountToaccount(withdrawOperationDto, accountDto);
     }
}
