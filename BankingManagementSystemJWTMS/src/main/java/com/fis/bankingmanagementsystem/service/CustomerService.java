package com.fis.bankingmanagementsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankingmanagementsystem.exception.CustomerNotFound;
import com.fis.bankingmanagementsystem.model.Customer;
import com.fis.bankingmanagementsystem.repo.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;

	public String createCustomer(Customer customer) {
		customerRepo.save(customer);
		return "Account created successfully with A/c No: "+customer.getAccNo();
	}

	public Customer getCustomerDetails(int accNo) throws CustomerNotFound {
		Optional<Customer> optional = customerRepo.findById(accNo);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new CustomerNotFound("Account Number not found!!!");
		}
	}

	public String deleteCustomer(int accNo) {
		customerRepo.deleteById(accNo);
		return "Customer having A/c no: " + accNo + " is deleted successfully!!!";
	}

}
