package com.laba.solvd.bank;

import com.laba.solvd.bank.dao.impl.AccountRepositoryImpl;
import com.laba.solvd.bank.dao.impl.CustomerRepositoryImpl;
import com.laba.solvd.bank.dao.interfaces.AccountRepository;
import com.laba.solvd.bank.dao.interfaces.CustomerRepository;
import com.laba.solvd.bank.model.Account;
import com.laba.solvd.bank.model.Customer;
import com.laba.solvd.bank.model.Transaction;
import com.laba.solvd.bank.service.impl.AccountServiceImpl;
import com.laba.solvd.bank.service.impl.CustomerServiceImpl;
import com.laba.solvd.bank.service.interfaces.AccountService;
import com.laba.solvd.bank.service.interfaces.CustomerService;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());

        Transaction transaction1=new Transaction();
        transaction1.setTransactionType("deposit");
        transaction1.setAmount(12000);
        String transactionDateStr1="05/05/2023";
        SimpleDateFormat dateFormat1=new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date transactionDate=dateFormat1.parse(transactionDateStr1);
            transaction1.setTransactionDate(transactionDate);
        }catch(ParseException e){
            logger.info(("Unable to set the date"),e);
        }
        Transaction transaction2=new Transaction();
        transaction2.setTransactionType("withdrawal");
        transaction2.setAmount(3000);
        String transactionDateStr2="07/08/2023";
        SimpleDateFormat dateFormat2=new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date transactionDate2=dateFormat2.parse(transactionDateStr2);
            transaction2.setTransactionDate(transactionDate2);
        }catch(ParseException e){
            logger.info(("Unable to set the date"),e);
        }
        Account account1=new Account();
        account1.setAccountType("debit");
        account1.setBalance(20000.0);
        account1.setTransaction(Arrays.asList(transaction1));

        Account account2=new Account();
        account2.setAccountType("debit");
        account2.setBalance(50000.0);
        account2.setTransaction(Arrays.asList(transaction1,transaction2));


        Customer customer=new Customer();
        customer.setFirstName("Emily");
        customer.setLastName("Meyer");
        customer.setAccount(Arrays.asList(account1,account2));

        CustomerService customerService=new CustomerServiceImpl();
        customer=customerService.createCustomer(customer);
        logger.info(customer);
       List<Customer> allCustomers=customerService.getAllCustomers();
       logger.info(allCustomers);
    }
}
