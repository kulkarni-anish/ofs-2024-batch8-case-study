package com.ofss.main.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
    private int accountId;
    @Column(name="is_approved")
    private boolean accountIsApproved;
    @Column(name="account_type")
    private String accountType;
    @Column(name="rate_of_interest")
    private float rateOfInterest;
    @Column(name="opening_date")
    private String openingDate;
    @Column(name="min_balance")
    private float minBalance;
    @Column(name="current_balance")
    private float currentBalance;
    @Column(name="overdraft_balance")
    private float overdraftBalance;
    @Column(name="max_overdraft")
    private float maximumOverdraft;
    @Column(name="customer_id")
    private int customerId;
    @Transient
    private BankCustomer bankCustomer;
    @Transient
    private float amount;
    
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public Account SavingsAccount(float currentBalance, int customerId) {
        this.accountType = "Savings";
        this.rateOfInterest = 7;
        this.minBalance = 1000;
        this.currentBalance = currentBalance;
        this.customerId = customerId;
        return this;
    }
    public Account CurrentAccount(float currentBalance,int customerId) {
        this.accountType = "Current";
        this.rateOfInterest = 0;
        this.minBalance = 0;
        this.maximumOverdraft = 50000;
        this.overdraftBalance = 50000;
        this.currentBalance = currentBalance;
        this.customerId = customerId;
        return this;
    }
    public Account(){

    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int account_id) {
        this.accountId = account_id;
    }
    public boolean isAccountIsApproved() {
        return accountIsApproved;
    }
    public void setAccountIsApproved(boolean accountIsApproved) {
        this.accountIsApproved = accountIsApproved;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public float getRateOfInterest() {
        return rateOfInterest;
    }
    public void setRateOfInterest(float rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }
    public String getOpeningDate() {
        return openingDate;
    }
    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }
    public float getMinBalance() {
        return minBalance;
    }
    public void setMinBalance(float minBalance) {
        this.minBalance = minBalance;
    }
    public float getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public float getOverdraftBalance() {
        return overdraftBalance;
    }
    public void setOverdraftBalance(float overdraftBalance) {
        this.overdraftBalance = overdraftBalance;
    }
    public float getMaximumOverdraft() {
        return maximumOverdraft;
    }
    public void setMaximumOverdraft(float maximumOverdraft) {
        this.maximumOverdraft = maximumOverdraft;
    }


    
}
