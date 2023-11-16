package com.fis.bankingmanagementsystem.testmodel;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.fis.bankingmanagementsystem.model.Transaction;

public class TransactionTest {
	Transaction transTest = new Transaction();
	
	 // declaring variables with actual and expected values to test
	int actualAccNo = transTest.setAccNo(202300001);
	int expectedAccNo = 202300001;
   
	// @Test annotation is displaying that this method is used for testing
	@Test
	void setAccNoTest() {
		assertEquals(expectedAccNo, actualAccNo);
	}

	String actualTypeOfTransaction = transTest.setTypeOfTransaction("Debit");
	String expectedTypeOfTransaction  = "Debit";

	@Test
	void setCustomerNameTest() {
		assertEquals(expectedTypeOfTransaction , actualTypeOfTransaction );
	}

	String actualStatusOfTransaction = transTest.setStatusOfTransaction("Success");
	String expectedStatusOfTransaction = "Success";

	@Test
	void setAccountTypeTest() {
		assertEquals(expectedStatusOfTransaction, actualStatusOfTransaction);
	}
	

}
