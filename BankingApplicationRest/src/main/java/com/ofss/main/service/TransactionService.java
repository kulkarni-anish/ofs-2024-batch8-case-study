package com.ofss.main.service;

import java.util.List;

import com.ofss.main.domain.Transaction;

public interface TransactionService {
    boolean registerTransaction(float amount,int crAccount,int drAccount, String type);
    List <Transaction> getAllTransactions();

}
