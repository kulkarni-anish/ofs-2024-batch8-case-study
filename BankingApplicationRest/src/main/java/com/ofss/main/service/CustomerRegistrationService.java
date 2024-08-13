package com.ofss.main.service;

import com.ofss.main.domain.BankCustomer;

public interface CustomerRegistrationService {
    BankCustomer addCustomer(BankCustomer bankCustomer);
    BankCustomer getBankCustomer(int customerId);
    BankCustomer updateCustomer(BankCustomer bankCustomer);
}
