package com.fis.bankingmanagementsystem.repo;

import org.springframework.data.repository.CrudRepository;

import com.fis.bankingmanagementsystem.model.Transaction;

public interface TransactionRepo extends CrudRepository<Transaction, Integer> {

}
