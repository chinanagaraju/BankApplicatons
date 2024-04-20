package org.Bank.Service;

import org.Bank.Dto.Response;
import org.Bank.Dto.WithdrawOperationDto;

public interface WithdrawService {
	Response withdrawMoney(WithdrawOperationDto withdrawOperationDto);

}
