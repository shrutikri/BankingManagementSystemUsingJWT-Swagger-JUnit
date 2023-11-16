package com.fis.bankingmanagementsystem.testmodel;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fis.bankingmanagementsystem.model.Accounts;

public class AccountTest {
	Accounts account = new Accounts();
	
    // declaring variables with actual and expected values to test
	int actualAccNo = account.setAccNo(202300001);
	int expectedAccNo = 202300001;
    
	// @Test annotation is displaying that this method is used for testing
	@Test
	void setAccNoTest() {
		assertEquals(expectedAccNo, actualAccNo);
	}

	int actualBalance = account.setBalance(60000);
	int expectedBalance = 60000;

	@Test
	void setBalanceTest() {
		assertEquals(expectedBalance, actualBalance);
	}
	
	String actualAccStatus = account.setAcctStatus("Active");
	String expectedAccStatus = "Active";

	@Test
	void setAccountStatusTest() {
		assertEquals(expectedAccStatus, actualAccStatus);
	}

}
