package com.laba.solvd.bank.parsers;

import com.laba.solvd.bank.model.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;
import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class JAXBParser implements Parser{
    public static Logger logger = Logger.getLogger(JAXBParser.class.getName());
    public Customer parse(String xmlFilePath) {
        Customer customer = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File xmlFile = new File(xmlFilePath);
            customer = (Customer) unmarshaller.unmarshal(xmlFile);

            logger.info("Customer ID: " + customer.getId());
            logger.info("First Name: " +customer.getFirstName());
            logger.info("Last Name: " + customer.getLastName());

            List<Account> accounts = customer.getAccount();
            for (Account account : accounts) {
                Long accountId = account.getId();
                String accountType = account.getAccountType();
                Double balance = account.getBalance();

                logger.info("Account ID: " + accountId);
                logger.info("Account Type: " + accountType);
                logger.info("Balance: " + balance);

                List<Transaction> transactions = account.getTransaction();
                List<Card> cards = account.getCard();
                List<Loan> loans = account.getLoan();

                for (Transaction transaction : transactions) {
                    logger.info("Transaction ID: " + transaction.getId());
                    logger.info("Transaction Type: " + transaction.getTransactionType());
                    logger.info("Amount: " + transaction.getAmount());
                    logger.info("Transaction Date: " + transaction.getTransactionDate());
                }

                for (Card card : cards) {
                    Long cardId = card.getId();
                    String cardNumber = card.getCardNumber();
                    Date expirationDate = card.getExpirationDate();

                    logger.info("Card ID: " + cardId);
                    logger.info("Card Number: " + cardNumber);
                    logger.info("Expiration Date: " + expirationDate);
                }

                for (Loan loan : loans) {
                    Long loanId = loan.getId();
                    Double loanAmount = loan.getLoanAmount();
                    Double interestRate = loan.getInterestRate();
                    String loanDuration = loan.getLoanDuration();

                    logger.info("Loan ID: " + loanId);
                    logger.info("Loan Amount: " + loanAmount);
                    logger.info("Interest Rate: " + interestRate);
                    logger.info("Loan Duration: " + loanDuration);
                }
            }
            }catch(JAXBException e){
                logger.error("Error");
            }
            return customer;

        }
    }
