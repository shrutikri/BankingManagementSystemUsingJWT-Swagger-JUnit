package com.fis.bankingmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankingmanagementsystem.exception.CustomerNotFound;
import com.fis.bankingmanagementsystem.model.Customer;
import com.fis.bankingmanagementsystem.service.CustomerService;

//{
//    "accNo": 202300001,
//    "custName": "Shruti",
//    "mobileNo": 9470718216,
//    "emailId": "shruti@gmail.com",
//    "aadharNo": 635645239812,
//    "dob": "2001/01/01",
//    "residentialAdd": "Bangalore",
//    "permanentAdd": "Patna",
//    "accType": "Savings"
//}
//
//{
//    "accNo": 202300002,
//    "custName": "Sonal",
//    "mobileNo": 9625354621,
//    "emailId": "sonal@gmail.com",
//    "aadharNo": 986253423123,
//    "dob": "2002/05/05",
//    "residentialAdd": "Mumbai",
//    "permanentAdd": "Mumbai",
//    "accType": "Savings"
//}
//
//{
//    "accNo": 202300003,
//    "custName": "Ankit",
//    "mobileNo": 9983477364,
//    "emailId": "ankit@gmail.com",
//    "aadharNo": 834836875234,
//    "dob": "2001/03/11",
//    "residentialAdd": "Bangalore",
//    "permanentAdd": "Puri",
//    "accType": "Current"
//}
// data for validations (email can not be empty)
//{
//    "accNo": 2023,
//    "custName": "Nishu",
//    "mobileNo": 8738647634,
//    "emailId": "",
//    "aadharNo": 986253423123,
//    "dob": "1999/05/21",
//    "residentialAdd": "Mumbai",
//    "permanentAdd": "Bihar",
//    "accType": "Current"
//}

/*
 * RestController: Use to create restful WebServices and also takes care of mapping request data 
 * to the defined request handler method. 
 */
@RestController
//RequestMapping: Used to map HTTP requests to handler methods
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountController accountController;

	// this method is used for creating customer
	// http://localhost:8080/customer/createCustomer
	@PostMapping("/createCustomer")
	public String createCustomer(@RequestBody @Validated Customer customer) {
		customerService.createCustomer(customer);
		accountController.createAccount(customer.getAccNo(),customer.getCustName(), 0, "Active");
		return "Account created successfully with A/c No: "+customer.getAccNo();
	}

	// this method is used to get the customer info as per their account number and
	// also handling the exception with a message
	// http://localhost:8080/customer/getCustomerDetails/202300001
	@GetMapping("/getCustomerDetails/{accNo}")
	public Customer getCustomerDetails(@PathVariable int accNo) throws CustomerNotFound {
		try {
			return customerService.getCustomerDetails(accNo);
		} catch (CustomerNotFound e) {
			// TODO Auto-generated catch block
			throw new CustomerNotFound("A/c no: "+accNo+" not found!");
		}
	}

	// this method is used to delete the customer as per the account number
	// http://localhost:8080/customer/deleteCustomer/202300003
	@DeleteMapping("/deleteCustomer/{accNo}")
	public String deleteCustomer(@PathVariable int accNo) throws CustomerNotFound {
		customerService.deleteCustomer(accNo);
		return "Customer having A/c no: "+accNo+" is deleted successfully!!!";
	}
}
