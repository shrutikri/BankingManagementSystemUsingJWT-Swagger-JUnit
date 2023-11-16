package com.fis.bankingmanagementsystem.testmodel;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.fis.bankingmanagementsystem.model.Customer;

public class CustomerTest {

	Customer custTest = new Customer();
	
	 // declaring variables with actual and expected values to test
	int actualAccNo = custTest.setAccNo(202300001);
	int expectedAccNo = 202300001;
    
	// @Test annotation is displaying that this method is used for testing
	@Test
	void setAccNoTest() {
		assertEquals(expectedAccNo, actualAccNo);
	}

	String actualName = custTest.setCustName("Shruti");
	String expectedName = "Shruti";

	@Test
	void setCustomerNameTest() {
		assertEquals(expectedName, actualName);
	}

	String actualAccType = custTest.setAccType("Savings");
	String expectedAccType = "Savings";

	@Test
	void setAccountTypeTest() {
		assertEquals(expectedAccType, actualAccType);
	}
	
	
}
