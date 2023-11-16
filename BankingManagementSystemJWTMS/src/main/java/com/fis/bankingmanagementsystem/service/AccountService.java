package com.fis.bankingmanagementsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankingmanagementsystem.exception.CustomerNotFound;
import com.fis.bankingmanagementsystem.model.Accounts;
import com.fis.bankingmanagementsystem.repo.AccountsRepo;

@Service
public class AccountService {
	@Autowired
	private AccountsRepo accountRepository;

	public void createAccount(Accounts acct) {
		accountRepository.save(acct);
	}

	public Accounts getAccountDetails(int accNo) throws CustomerNotFound {
		Optional<Accounts> optional = accountRepository.findById(accNo);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new CustomerNotFound("A/c no: "+accNo+" not found!");
		}
	}

	public void deleteAccountStatus(int accNo) {
		accountRepository.deleteById(accNo);
	}

	public int getBalance(int accNo) {
		return accountRepository.findBalanceByAccNo(accNo);
	}

	public String depositAmount(int accNo, int amount) {
		accountRepository.saveBalanceByAccNo(accNo, amount);
		return accNo + " credited successfully by " + amount;
		
	}

	public String withdrawAmount(int accNo, int amount) {
		accountRepository.withdrawAmountByAccNo(accNo, amount);
		return accNo + " debited successfully by " + amount;
	}

	public void fundTransfer(int accNo, int recAccNo, int amount) {
		accountRepository.withdrawAmountByAccNo(accNo, amount);
		accountRepository.saveBalanceByAccNo(recAccNo, amount);
	}

}
