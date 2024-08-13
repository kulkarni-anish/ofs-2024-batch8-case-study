package com.ofss.main.service;
import com.ofss.main.domain.LoginDetails;

public interface CustomerLoginService {
    LoginDetails createLoginCreds(LoginDetails loginDetails);
    LoginDetails login(String username, String password);
    boolean isLoggedIn(String customer_id);
    boolean logout(int customer_id);
    LoginDetails getLoginCreds(int login_id);
}