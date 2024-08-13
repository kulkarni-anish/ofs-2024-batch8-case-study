package com.ofss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.BankCustomer;
import com.ofss.main.domain.LoginDetails;
import com.ofss.main.service.CustomerLoginService;
import com.ofss.main.service.CustomerRegistrationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("login")
public class CustomerLoginController {
    @Autowired
	private CustomerLoginService customerLoginService;
    @PostMapping("create")
	public LoginDetails createLogin(@RequestBody LoginDetails loginDetails) {
		return customerLoginService.createLoginCreds(loginDetails);
	}
    @PostMapping("login")
	public LoginDetails login(@RequestBody LoginDetails loginDetails) {
		return customerLoginService.login(loginDetails.getUsername(),loginDetails.getPassword());
	}
    @GetMapping("login/{login_id}")
    public LoginDetails getLoginDetails(@PathVariable int login_id) {
        return customerLoginService.getLoginCreds(login_id);
    }
    
}
