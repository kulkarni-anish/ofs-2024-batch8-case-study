package com.ofss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.BankCustomer;
import com.ofss.main.service.CustomerRegistrationService;

@RestController
@RequestMapping("registration")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CustomerRegistrationController {
    @Autowired
	private CustomerRegistrationService customerRegistrationService;
    @PostMapping("customer")
	public ResponseEntity<BankCustomer>  addNewEmployeeToDB(@RequestBody BankCustomer bankCustomer) {
        BankCustomer bankCustomer2 = customerRegistrationService.addCustomer(bankCustomer);
		return new ResponseEntity<>(bankCustomer2,null,200);
	}
    @GetMapping("customer/{customer_id}")
    public ResponseEntity<BankCustomer> getCustomerById(@PathVariable int customer_id){
        BankCustomer bankCustomer2 = customerRegistrationService.getBankCustomer(customer_id);
        return new ResponseEntity<>(bankCustomer2,null,200);

    }
    @PutMapping("customer")
    public ResponseEntity<BankCustomer> getCustomerById(@RequestBody BankCustomer bankCustomer){
        BankCustomer bankCustomer2 = customerRegistrationService.updateCustomer(bankCustomer);
        return new ResponseEntity<>(bankCustomer2,null,200);

    }
}
