package com.ofss.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.BankCustomer;
import com.ofss.main.repository.CustomerRegistration;

@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService{
	@Autowired
	private CustomerRegistration customerRepository;

	@Override
	public BankCustomer addCustomer(BankCustomer bankCustomer) {
		BankCustomer bankCustomer2 = customerRepository.save(bankCustomer);
		return bankCustomer2;
	}

	@Override
	public BankCustomer getBankCustomer(int customerId) {
		// TODO Auto-generated method stub
		Optional<BankCustomer> bankOptional = customerRepository.findById(customerId);
		if (bankOptional.isPresent()){
			return bankOptional.get();
		}
		return null;
	}

	@Override
	public BankCustomer updateCustomer(BankCustomer bankCustomer) {
		BankCustomer bankCustomer2 = customerRepository.save(bankCustomer);
		return bankCustomer2;
	}


}