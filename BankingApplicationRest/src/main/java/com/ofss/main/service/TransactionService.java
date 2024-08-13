package com.ofss.main.service;

public interface TransactionService {
    boolean registerTransaction(float amount,int crAccount,int drAccount, String type);

}
