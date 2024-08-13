package com.ofss.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Transaction;
import com.ofss.main.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    TransactionRepository repository;
    @Override
    public boolean registerTransaction(float amount,int crAccount,int drAccount, String type) {
        if(crAccount==drAccount){
            Transaction transaction = new Transaction();
            transaction.selfTransaction(amount, type, drAccount);
            repository.save(transaction);
            return true;
        }
        else{
            Transaction transaction = new Transaction(amount, type, drAccount, crAccount);
            repository.save(transaction);
            return true;
        }
    }
}
