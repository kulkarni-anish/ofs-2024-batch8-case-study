package com.ofss.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Transaction;
import com.ofss.main.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("transactions")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @GetMapping("all")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

}
