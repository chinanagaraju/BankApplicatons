package org.Bank.repo;

import javax.persistence.Id;

import org.Bank.entity.WithdraOperation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WithdrawRepo extends CrudRepository<WithdraOperation, Id>{
	

	WithdraOperation findByAccountNumber(String accountNumber);

}
