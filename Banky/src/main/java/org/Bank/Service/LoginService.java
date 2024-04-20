package org.Bank.Service;

import java.util.ArrayList;

import org.Bank.Dto.LoginDto;
import org.Bank.Dto.Response;
import org.Bank.entity.UserLogin;


public interface LoginService {
	Response addUser(LoginDto loginDto);
	Response loginOp(LoginDto loginDto);
	ArrayList<UserLogin> getAll();

}
