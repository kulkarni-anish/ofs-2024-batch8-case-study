package com.ofss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.LoginDetails;
import com.ofss.main.service.CustomerLoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("login")
public class CustomerLoginController {
    @Autowired
	private CustomerLoginService customerLoginService;
    @PostMapping("create")
	public ResponseEntity<LoginDetails> createLogin(@RequestBody LoginDetails loginDetails) {
		LoginDetails login = customerLoginService.createLoginCreds(loginDetails);
        return new ResponseEntity<>(login, null, 200);
	}
    @PostMapping("")
	public ResponseEntity<LoginDetails> login(@RequestBody LoginDetails loginDetails) {
		LoginDetails login = customerLoginService.login(loginDetails.getUsername(),loginDetails.getPassword());
        return new ResponseEntity<>(login,null,200);
	}
    @GetMapping("{login_id}")
    public ResponseEntity<LoginDetails> getLoginDetails(@PathVariable int login_id) {
        LoginDetails login = customerLoginService.getLoginCreds(login_id);
        return new ResponseEntity<>(login,null,200);
    }
    
}
