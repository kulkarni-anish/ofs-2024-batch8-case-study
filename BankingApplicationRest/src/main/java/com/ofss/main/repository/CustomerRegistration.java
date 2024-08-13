package com.ofss.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.ofss.main.domain.BankCustomer;

public interface CustomerRegistration extends CrudRepository<BankCustomer, Integer>{
}
