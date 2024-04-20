package org.Bank.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.Bank.Dto.LoginDto;
import org.Bank.Dto.Response;
import org.Bank.Service.LoginService;
import org.Bank.entity.Account;
import org.Bank.entity.Transfer;
import org.Bank.entity.UserLogin;
import org.Bank.repo.BankRepo;
import org.Bank.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginServiceImpl implements LoginService {
   @Autowired
   private LoginRepo loginRepo;
   @Autowired
   private BankRepo bankRepo;
   @Override
   public Response addUser(LoginDto loginDto) {
     
       if (loginDto == null) {
           return new Response("Please provide user details.", false);
       }
      
       if (loginDto.getUserName().isEmpty() ||
           loginDto.getPassword().isEmpty() ||
           loginDto.getBankName().isEmpty()||
       loginDto.getIfsc().isEmpty()|| loginDto.getAccountNumber().toString().isEmpty()){
           return new Response("All input fields must be filled in.", false);
       }


      String accountNumber=loginDto.getAccountNumber().toString();
       if (accountNumber == null) {
           return new Response("Account number is required.", false);
       }

        
       Account account = bankRepo.findByAccountNumber(accountNumber);
       if (account == null) {
           return new Response("Please create an account first.", false);
       }

       UserLogin existingUserLogin = loginRepo.findByAccountNumber(accountNumber);
       if (existingUserLogin != null && existingUserLogin.getUserName().equals(loginDto.getUserName()) && existingUserLogin.getAccountNumber()==loginDto.getAccountNumber()&&existingUserLogin.getBankName().equalsIgnoreCase(loginDto.getBankName())) {
           return new Response("User already exists. Please try logging in.", false);
       }


       String passwordPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&*])[A-Za-z\\d@#$%^&*]{8,}$";
       if (!loginDto.getPassword().matches(passwordPattern)) {
           return new Response("Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.", false);
       }

       // Validate username length
       if (loginDto.getUserName().length() >25) {
           return new Response("Username length should be up to 25 characters.", false);
       }

       // Create new user login record
       UserLogin newUserLogin = new UserLogin(
           loginDto.getId(),
           loginDto.getUserName(),
           loginDto.getPassword(),
           accountNumber,
           loginDto.getBankName(),
           loginDto.getIfsc()
       );

       
       loginRepo.save(newUserLogin);
       
   
       return new Response("User profile successfully created.", true);
   }
	@Override
	public Response loginOp(LoginDto loginDto) {
		// TODO Auto-generated method stub
	
		UserLogin userLogin=loginRepo.findByAccountNumber(loginDto.getAccountNumber());
		if(userLogin==null) {
			return new Response("Signup then try again",false);
		}
		if(userLogin.getPassword().equals(loginDto.getPassword())&&userLogin.getUserName().equalsIgnoreCase(loginDto.getUserName())&&userLogin.getBankName().equalsIgnoreCase(loginDto.getBankName())) {
			
			
			Account account=bankRepo.findByAccountNumber(loginDto.getAccountNumber());
			if(account!=null) {
			Transfer transaction=new Transfer(userLogin.getAccountNumber(),userLogin.getUserName(),userLogin.getBankName(),account.getIfsc());
			System.out.print(transaction +"trasncation");
			return new Response("you succesfully login",true);
			}
			return new Response("you din't have account  create one try again",false);
		}else {
			return new Response("create account and try login", false);
		}
		
		
	}
		
	@Override
	public ArrayList<UserLogin> getAll() {
	ArrayList<UserLogin> login=(ArrayList<UserLogin>)loginRepo.findAll();
		
		return login ;
	}

}
