package com.laba.solvd.bank;

import com.laba.solvd.bank.dao.impl.AccountMapperImpl;
import com.laba.solvd.bank.dao.impl.CustomerMapperImpl;
import com.laba.solvd.bank.dao.interfaces.AccountMapper;
import com.laba.solvd.bank.dao.interfaces.AccountRepository;
import com.laba.solvd.bank.dao.ConnectionPool;
import com.laba.solvd.bank.dao.interfaces.CustomerMapper;
import com.laba.solvd.bank.dao.interfaces.CustomerRepository;
import com.laba.solvd.bank.dao.impl.AccountRepositoryImpl;
import com.laba.solvd.bank.dao.impl.CustomerRepositoryImpl;
import com.laba.solvd.bank.model.Account;
import com.laba.solvd.bank.model.Customer;
import com.laba.solvd.bank.service.AccountService;
import com.laba.solvd.bank.service.CustomerService;
import com.laba.solvd.bank.service.impl.AccountServiceImpl;
import com.laba.solvd.bank.service.impl.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        AccountMapper accountMapper = new AccountMapperImpl();
        AccountRepository accountRepository = new AccountRepositoryImpl(connectionPool,accountMapper);
        CustomerMapper customerMapper=new CustomerMapperImpl();
        CustomerRepository customerRepository = new CustomerRepositoryImpl(connectionPool, customerMapper);

        AccountService accountService = new AccountServiceImpl(accountRepository);
        CustomerService customerService = new CustomerServiceImpl(customerRepository);

// Created a new account,customer
        Account account1 = new Account(1, "Savings", 1000.0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        accountService.createAccount(account1);

        Customer customer = new Customer(1001,"Aika","Kalil",new ArrayList<>(),null);
        customerService.createCustomer(customer);

        // Got all accounts,customers
        List<Account> accounts = accountService.getAllAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
        List<Customer> customers = customerService.getAllCustomers();
        System.out.println("All Customers:");
        for (Customer c : customers) {
            System.out.println(c);
        }

        // Updated an account
        Account accountToUpdate = accounts.get(0);
        accountToUpdate.setBalance(2000.0);
        accountService.updateAccount(accountToUpdate);

        // Deleted a customer by ID
        int customerIdToDelete = 1001;
        customerService.deleteCustomerById(customerIdToDelete);
    }
}
