package org.Bank.repo;



import java.math.BigInteger;
import java.util.Optional;

import javax.persistence.Id;

import org.Bank.Dto.AccountDto;
import org.Bank.entity.Account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends CrudRepository<Account, Id> {
    
     


	Account findByAccountNumber(String accountNumber) ;


	Account findByUserName(String userName);




	

	


}
