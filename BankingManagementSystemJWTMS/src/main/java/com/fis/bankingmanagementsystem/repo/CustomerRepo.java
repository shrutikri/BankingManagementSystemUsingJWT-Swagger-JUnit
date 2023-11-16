package com.fis.bankingmanagementsystem.repo;

import org.springframework.data.repository.CrudRepository;

import com.fis.bankingmanagementsystem.model.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {

}
