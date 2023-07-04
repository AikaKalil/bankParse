package com.laba.solvd.bank.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laba.solvd.bank.model.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JacksonParser implements Parser {
    @Override
    public Customer parse(String filePath) {
        Customer customer = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = new File(filePath);
            customer = mapper.readValue(jsonFile, Customer.class);

            System.out.println("Customer ID: " + customer.getId());
            System.out.println("First Name: " + customer.getFirstName());
            System.out.println("Last Name: " + customer.getLastName());

            List<Account> accounts = customer.getAccount();

            for (Account account : accounts) {
                System.out.println("Account ID: " + account.getId());
                System.out.println("Account Type: " + account.getAccountType());
                System.out.println("Balance: " + account.getBalance());

                List<Transaction> transactions = account.getTransaction();
                for (Transaction transaction : transactions) {
                    System.out.println("Transaction ID: " + transaction.getId());
                    System.out.println("Transaction Type: " + transaction.getTransactionType());
                    System.out.println("Amount: " + transaction.getAmount());
                    System.out.println("Transaction Date: " + transaction.getTransactionDate());
                }

                List<Card> cards = account.getCard();
                for (Card card : cards) {
                    System.out.println("Card ID: " + card.getId());
                    System.out.println("Card Number: " + card.getCardNumber());
                    System.out.println("Expiration Date: " + card.getExpirationDate());

                    CardType cardType = card.getCardType();
                    System.out.println("Card Type ID: " + cardType.getId());
                    System.out.println("Credit: " + cardType.getCredit());
                    System.out.println("Debit: " + cardType.getDebit());
                }

                List<Loan> loans = account.getLoan();
                for (Loan loan : loans) {
                    System.out.println("Loan ID: " + loan.getId());
                    System.out.println("Loan Amount: " + loan.getLoanAmount());
                    System.out.println("Interest Rate: " + loan.getInterestRate());
                    System.out.println("Loan Duration: " + loan.getLoanDuration());
                }
            }
        } catch (IOException e) {
            System.out.println("error occurred");
        }
        return customer;
    }
}
