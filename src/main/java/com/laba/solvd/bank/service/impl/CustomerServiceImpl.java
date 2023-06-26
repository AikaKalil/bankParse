package com.laba.solvd.bank.service.impl;

import com.laba.solvd.bank.dao.interfaces.AccountRepository;
import com.laba.solvd.bank.dao.interfaces.CustomerRepository;
import com.laba.solvd.bank.model.Account;
import com.laba.solvd.bank.model.Customer;
import com.laba.solvd.bank.service.interfaces.AccountService;
import com.laba.solvd.bank.service.interfaces.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;
    private AccountService accountService;

    public CustomerServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository, AccountService accountService) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }
    public CustomerServiceImpl() {

    }

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setId(null);
        customerRepository.create(customer);
        if (customer.getAccount()!= null) {
            List<Account> accounts = customer.getAccount().stream()
                    .map(account -> accountService.createAccount(account))
                    .collect(Collectors.toList());
            for (Account account : accounts) {
                accountRepository.update(account,customer);
            }
        }
        return customer;
    }


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}

