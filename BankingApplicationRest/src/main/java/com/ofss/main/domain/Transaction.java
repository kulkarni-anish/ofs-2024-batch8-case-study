package com.ofss.main.domain;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transaction_id")
    private int transactionId;
    @Column(name="type")
    private String type;
    @Column(name="timestamp")
    @CreationTimestamp
    private String timestamp;
    @Column(name="amount")
    private float amount;
    @Column(name="dt_account")
    private int dtAccount;
    @Column(name="cr_account")
    private int crAccount;
    @Column(name="status")
    private String status;
    public Transaction(float amount, String type, int dtAccount,
            int crAccount) {
        this.type = type;
        this.amount = amount;
        this.dtAccount = dtAccount;
        this.crAccount = crAccount;
        this.status = "Completed";
    }
    public void selfTransaction(float amount, String type, int accountId){
        this.type = type;
        this.amount = amount;
        this.crAccount = accountId;
        this.dtAccount = accountId;
        this.status = "Completed";
    }
    public Transaction(){}

    public int getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public int getDtAccount() {
        return dtAccount;
    }
    public void setDtAccount(int dtAccount) {
        this.dtAccount = dtAccount;
    }
    public int getCrAccount() {
        return crAccount;
    }
    public void setCrAccount(int crAccount) {
        this.crAccount = crAccount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
