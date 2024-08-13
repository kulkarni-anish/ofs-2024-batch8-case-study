package com.ofss.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.LoginDetails;
import com.ofss.main.repository.CustomerLoginRepository;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{

    @Autowired
    private CustomerLoginRepository customerLoginRepository;

    @Override
    public LoginDetails createLoginCreds(LoginDetails loginDetails) {
        LoginDetails loginDetails1 = customerLoginRepository.save(loginDetails);
        return loginDetails1;
    }

    @Override
    public LoginDetails login(String username, String password) {
        LoginDetails loginDetails = customerLoginRepository.findByUsername(username);
        if (loginDetails!=null) {
            LoginDetails loginDetails2 = customerLoginRepository.findByUsernameAndPassword(username, password);
            if(loginDetails2!=null && loginDetails2.isAllowed()==true){
                loginDetails2.setLoggedIn(true);
                loginDetails2.setLoginAttempt(0);
                customerLoginRepository.save(loginDetails2);
            }else{
                loginDetails.setLoginAttempt(loginDetails.getLoginAttempt()+1);
                if(loginDetails.getLoginAttempt()>3){
                    loginDetails.setAllowed(false);
                }
                loginDetails.setLoggedIn(false);
                customerLoginRepository.save(loginDetails);
            }
        }
        else{
            return null; //Add exceptions
        }
        return loginDetails;
    }

    @Override
    public boolean isLoggedIn(String customer_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isLoggedIn'");
    }

    @Override
    public boolean logout(int customer_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }

    @Override
    public LoginDetails getLoginCreds(int login_id) {
        Optional <LoginDetails> optional= customerLoginRepository.findById(login_id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }   
    
}
