package com.ofss.main.domain;

public class Account{
    private int account_id;
    private boolean accountIsApproved;
    private String accountType;
    private float rateOfInterest;
    private String openingDate;
    private float minBalance;
    private float currentBalance;
    private float overdraftBalance;
    private float maximumOverdraft;
    private int customerId;
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
        return account_id;
    }
    public void setAccountId(int account_id) {
        this.account_id = account_id;
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
