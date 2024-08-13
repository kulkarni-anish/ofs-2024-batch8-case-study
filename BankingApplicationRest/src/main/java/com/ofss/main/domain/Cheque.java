package com.ofss.main.domain;

public class Cheque {
    public Cheque(int chequeNo, String chequeDate, Account payerId, Account payeeId, float amount) {
        this.chequeNo = chequeNo;
        this.chequeDate = chequeDate;
        this.payerId = payerId;
        this.payeeId = payeeId;
        this.amount = amount;
    }
    private int chequeNo;
    private String chequeDate;
    private Account payerId;
    private Account payeeId;
    private float amount;
    public int getChequeNo() {
        return chequeNo;
    }
    public void setChequeNo(int chequeNo) {
        this.chequeNo = chequeNo;
    }
    public String getChequeDate() {
        return chequeDate;
    }
    public void setChequeDate(String chequeDate) {
        this.chequeDate = chequeDate;
    }
    public Account getPayerId() {
        return payerId;
    }
    public void setPayerId(Account payerId) {
        this.payerId = payerId;
    }
    public Account getPayeeId() {
        return payeeId;
    }
    public void setPayeeId(Account payeeId) {
        this.payeeId = payeeId;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
}
