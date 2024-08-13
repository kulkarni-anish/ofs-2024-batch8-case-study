package com.ofss.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account createSavingsAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account createCurrentAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public boolean deposit(int account_id, float amount) {
        Account dbAccount;
        Optional<Account> account = accountRepository.findById(account_id);
        if (account.isPresent()) {
            dbAccount = account.get();
        }
        else{
            return false;
        }

        if (dbAccount.getAccountType().equals("Savings")){
            dbAccount.setCurrentBalance(dbAccount.getCurrentBalance()+amount);
            accountRepository.save(dbAccount);
            return true;
        }
        else if(dbAccount.getAccountType().equals("Current")){
            float overdraftBalance = dbAccount.getOverdraftBalance();
            float overdraftLimit = dbAccount.getMaximumOverdraft();
            if(amount>0){
                if(overdraftBalance<overdraftLimit){
                    if((overdraftBalance+amount)>overdraftLimit){
                        dbAccount.setCurrentBalance(amount-(overdraftLimit-overdraftBalance));
                        dbAccount.setOverdraftBalance(overdraftLimit);
                        accountRepository.save(dbAccount);
                        return true;
                    }
                    else{
                        dbAccount.setOverdraftBalance(dbAccount.getOverdraftBalance()+amount);
                        accountRepository.save(dbAccount);
                        return true;
                    }
                }
                else{
                    dbAccount.setCurrentBalance(dbAccount.getCurrentBalance()+amount);
                    accountRepository.save(dbAccount);
                    return true;
                }
            }
        }
        return false;
        
    }

    @Override
    public boolean withdraw(int account_id, float amount) {
        Account dbAccount;
        Optional<Account> account = accountRepository.findById(account_id);
        if (account.isPresent()) {
            dbAccount = account.get();
        }else{
            return false;
        }
        if (dbAccount.getAccountType().equals("Savings")){
            if(amount>0 && amount<=dbAccount.getCurrentBalance()){
                dbAccount.setCurrentBalance(dbAccount.getCurrentBalance()-amount);
                accountRepository.save(dbAccount);
                return true;
            }
        }
        else if(dbAccount.getAccountType().equals("Current")){
            float overdraftBalance = dbAccount.getOverdraftBalance();
            float currentBalance = dbAccount.getCurrentBalance();
            if(amount<overdraftBalance+currentBalance){
                if(amount>currentBalance){
                    dbAccount.setOverdraftBalance((overdraftBalance-(amount-currentBalance)));
                    dbAccount.setCurrentBalance(0);
                    accountRepository.save(dbAccount);
                    return true;
    
                }
                else{
                    dbAccount.setCurrentBalance(currentBalance-amount);
                    accountRepository.save(dbAccount);
                    return true;
                }
            }
            return false;
        }

        return false;
    }

    @Override
    public Account getBalances(int account_id) {
        Optional<Account> account = accountRepository.findById(account_id);
        if (account.isPresent()) {
            return account.get();
        }
        return null;
    }

}
