package com.ofss.main.domain;

public class FDAccount {
    private BankCustomer customerId;
    private FixedDeposit fdId;
    private int fdAccountId;
    private String startDate;
    private String maturityDate;  // add auto calculate
    private float initInvestment;
    private float currentAmount;
    public FDAccount(BankCustomer customerId, FixedDeposit fdId, int fdAccountId, String startDate, String maturityDate,
            float initInvestment, float currentAmount) {
        this.customerId = customerId;
        this.fdId = fdId;
        this.fdAccountId = fdAccountId;
        this.startDate = startDate;
        this.maturityDate = maturityDate;
        this.initInvestment = initInvestment;
        this.currentAmount = currentAmount;
    }
    public BankCustomer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(BankCustomer customerId) {
        this.customerId = customerId;
    }
    public FixedDeposit getFdId() {
        return fdId;
    }
    public void setFdId(FixedDeposit fdId) {
        this.fdId = fdId;
    }
    public int getFdAccountId() {
        return fdAccountId;
    }
    public void setFdAccountId(int fdAccountId) {
        this.fdAccountId = fdAccountId;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getMaturityDate() {
        return maturityDate;
    }
    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }
    public float getInitInvestment() {
        return initInvestment;
    }
    public void setInitInvestment(float initInvestment) {
        this.initInvestment = initInvestment;
    }
    public float getCurrentAmount() {
        return currentAmount;
    }
    public void setCurrentAmount(float currentAmount) {
        this.currentAmount = currentAmount;
    }
}
