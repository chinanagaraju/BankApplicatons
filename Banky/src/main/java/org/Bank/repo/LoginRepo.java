package org.Bank.repo;

import java.math.BigInteger;

import javax.persistence.Id;

import org.Bank.entity.UserLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LoginRepo  extends CrudRepository<UserLogin, Id>{

	UserLogin findByAccountNumber(String accountNumber);

}
