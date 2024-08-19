package com.ofss.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Account;
import com.ofss.main.service.AccountService;
import com.ofss.main.service.TransactionService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("accounts")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping("")
    public List<Account> getAccounts(@RequestParam int customerId) {
        List<Account> accounts = accountService.getAccounts(customerId);
        return accounts;
    }

    @GetMapping("{accountId}")
    public Account getAccountById(@PathVariable int accountId) {
        return accountService.getBalances(accountId);
    }
    
    
    @PostMapping("savings")
    public Account createSavingsAccount(@RequestBody Account account) {
        Account newAccount = new Account();
        newAccount.SavingsAccount(account.getCurrentBalance(),account.getCustomerId());
        return accountService.createSavingsAccount(newAccount);
    }

    @PostMapping("current")
    public Account createCurrentAccount(@RequestBody Account account) {
        Account newAccount = new Account();
        newAccount.CurrentAccount(account.getCurrentBalance(),account.getCustomerId());
        return accountService.createSavingsAccount(newAccount);
    }
    
    @PostMapping("deposit")
    public boolean depositInAccount(@RequestBody Account account) {
        boolean status = accountService.deposit(account.getAccountId(),account.getAmount());
        if (status) {
            transactionService.registerTransaction(account.getAmount(), account.getAccountId(), account.getAccountId(), "Deposit");
            System.out.println("Deposit has been processed");
            return true;
        }
        return false;
    }

    @PostMapping("withdraw")
    public boolean withdrawFromAccount(@RequestBody Account account) {
        boolean status = accountService.withdraw(account.getAccountId(),account.getAmount());
        if(status){
            transactionService.registerTransaction(account.getAmount(), account.getAccountId(), account.getAccountId(), "Withdrawal");
            return true;
        }else{
            return false;
        }
    }
}
