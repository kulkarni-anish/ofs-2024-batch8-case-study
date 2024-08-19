package com.ofss.main.service;

import java.util.List;

import com.ofss.main.domain.Account;

public interface AccountService {
    Account createSavingsAccount(Account account);
    Account createCurrentAccount(Account account);
    boolean deposit(int account_id, float amount);
    boolean withdraw(int account_id, float amount);
    Account getBalances(int account_id);
    List<Account> getAccounts(int customerId);
}
