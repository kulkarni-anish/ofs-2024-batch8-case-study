package com.ofss.main.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table(name="login_details")
public class LoginDetails {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="login_id")
    private int loginId;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="customer_id")
    private int customerId;
    @Column(name="login_attempt")
    private int loginAttempt;
    @Column(name="is_allowed")
    private boolean isAllowed;
    @Column(name="is_logged_in")
    private boolean isLoggedIn;
    @Transient
    private BankCustomer bankCustomer;
    public LoginDetails(String username, String password, int customerId) {
        this.username = username;
        this.password = password;
        this.customerId = customerId;
    }
    public LoginDetails(){}
    public int getLoginId() {
        return loginId;
    }
    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getLoginAttempt() {
        return loginAttempt;
    }
    public void setLoginAttempt(int loginAttempt) {
        this.loginAttempt = loginAttempt;
    }
    public boolean isAllowed() {
        return isAllowed;
    }
    public void setAllowed(boolean isAllowed) {
        this.isAllowed = isAllowed;
    }
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    public BankCustomer getBankCustomer() {
        return bankCustomer;
    }
    public void setBankCustomer(BankCustomer bankCustomer) {
        this.bankCustomer = bankCustomer;
    }
    
}
