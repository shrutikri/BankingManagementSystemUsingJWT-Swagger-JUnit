package com.fis.bankingmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankingmanagementsystem.exception.CustomerNotFound;
import com.fis.bankingmanagementsystem.model.Accounts;
import com.fis.bankingmanagementsystem.model.Transaction;
import com.fis.bankingmanagementsystem.service.AccountService;

/*
 * RestController: Use to create restful WebServices and also takes care of mapping request data 
 * to the defined request handler method. 
 */
@RestController
//RequestMapping: Used to map HTTP requests to handler methods
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionController transactionController;

	// createAccount happens upon createCustomer
	public void createAccount(@RequestBody @Validated int accNo, String custName, int balance, String acctStatus) {
		Accounts acct = new Accounts(accNo, custName, balance, acctStatus);
		accountService.createAccount(acct);
	}

	// this method is used for depositing Amount
	// http://localhost:8080/account/202300001/deposit/90000
	@PutMapping("/{accNo}/deposit/{amount}")
	public String depositAmount(@PathVariable int accNo, @PathVariable int amount) throws CustomerNotFound {
		int previousBal = getBalance(accNo);
		accountService.depositAmount(accNo, amount);
		Transaction transaction = new Transaction(accNo, "Credited", "Success", previousBal, previousBal + amount);
		transactionController.addTransactions(transaction);
		return accNo + " credited successfully by " + amount;
	}

	// this method is used for withdrawing Amount
	// http://localhost:8080/account/202300001/withdraw/10000
	@PutMapping("/{accNo}/withdraw/{amount}")
	public String withdrawAmount(@PathVariable int accNo, @PathVariable int amount) throws CustomerNotFound {
		int previousBal = getBalance(accNo);
		if (previousBal >= amount) {
			accountService.withdrawAmount(accNo, amount);
			Transaction transaction = new Transaction(accNo, "Debit", "Success", previousBal, previousBal - amount);
			transactionController.addTransactions(transaction);
			return accNo + " debited successfully by " + amount;
		} else {
			return "Insufficient Balance";
		}

	}

	// this method is used for transferring Amount
	// http://localhost:8080/account/202300001/transfer/202300002/10000
	@PutMapping("/{accNo}/transfer/{recAccNo}/{amount}")
	public String fundTransfer(@PathVariable int accNo, @PathVariable int recAccNo, @PathVariable int amount)
			throws CustomerNotFound {
		int previousBalSender = getBalance(accNo);
		int previousBalReceiver = getBalance(recAccNo);
		if (previousBalSender >= amount) {
			accountService.fundTransfer(accNo, recAccNo, amount);
			Transaction moneySender = new Transaction(accNo, "Fund Transferring", "Success", previousBalSender,
					previousBalSender - amount);
			transactionController.addTransactions(moneySender);
			Transaction moneyReceiver = new Transaction(recAccNo, "Fund Receiving", "Success", previousBalReceiver,
					previousBalReceiver + amount);
			transactionController.addTransactions(moneyReceiver);
			return amount + " transferred Successfully from " + accNo + " to " + recAccNo;
		} else {
			return "Insufficient Balance";
		}
	}

	// this method is used for checking the Balance
	// http://localhost:8080/account/202300001/balance
	@GetMapping("/{accNo}/balance")
	public int getBalance(@PathVariable int accNo) throws CustomerNotFound {
		return accountService.getBalance(accNo);
	}

	// this method is used for deleting the Account
	// http://localhost:8080/account/deleteAccountStatus/202300003
	@DeleteMapping("/deleteAccountStatus/{accNo}")
	public String deleteAccountStatus(@PathVariable int accNo) throws CustomerNotFound {
		accountService.deleteAccountStatus(accNo);
		transactionController.deleteTransactions(accNo);
		return accNo + " details deleted successfully!!!";
	}

	// this method is used for getting Account Details
	// http://localhost:8080/account/getAccountDetails/202300001
	@GetMapping("/getAccountDetails/{accNo}")
	public Accounts getAccountDetails(@PathVariable int accNo) throws CustomerNotFound {
		try {
			return accountService.getAccountDetails(accNo);
		} catch (CustomerNotFound e) {
			// TODO Auto-generated catch block
			throw new CustomerNotFound("A/c no: " + accNo + " not found!");

		}
	}

}
