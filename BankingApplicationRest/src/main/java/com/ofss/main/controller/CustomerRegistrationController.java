package com.ofss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.BankCustomer;
import com.ofss.main.service.CustomerRegistrationService;

@RestController
@RequestMapping("registration")
public class CustomerRegistrationController {
    @Autowired
	private CustomerRegistrationService customerRegistrationService;
    @PostMapping("customer")
	public BankCustomer addNewEmployeeToDB(@RequestBody BankCustomer bankCustomer) {
		return customerRegistrationService.addCustomer(bankCustomer);
	}
    @GetMapping("customer/{customer_id}")
    public BankCustomer getCustomerById(@PathVariable int customer_id){
        return customerRegistrationService.getBankCustomer(customer_id);
    }
    @PutMapping("customer")
    public BankCustomer getCustomerById(@RequestBody BankCustomer bankCustomer){
        return customerRegistrationService.updateCustomer(bankCustomer);
    }
}
