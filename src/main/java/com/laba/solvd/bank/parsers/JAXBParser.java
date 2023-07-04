package com.laba.solvd.bank.parsers;
import com.laba.solvd.bank.model.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;
import java.io.File;
import java.util.List;

public class JAXBParser implements Parser{
    public static Logger logger = Logger.getLogger(JAXBParser.class.getName());
    public Customer parse(String xmlFilePath) {
        Customer customer = null;

        try {
            File xmlFile = new File(xmlFilePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            customer = (Customer) unmarshaller.unmarshal(xmlFile);

            logger.info("Customer ID: " + customer.getId());
            logger.info("First Name: " +customer.getFirstName());
            logger.info("Last Name: " + customer.getLastName());

            List<Account> accounts = customer.getAccount();
            for (Account account : accounts) {
                logger.info("Account ID: " + account.getId());
                logger.info("Account Type: " + account.getAccountType());
                logger.info("Balance: " + account.getBalance());

                List<Transaction> transactions = account.getTransaction();
                for (Transaction transaction : transactions) {
                    logger.info("Transaction ID: " + transaction.getId());
                    logger.info("Transaction Type: " + transaction.getTransactionType());
                    logger.info("Amount: " + transaction.getAmount());
                    logger.info("Transaction Date: " + transaction.getTransactionDate());
                }
                List<Card> cards = account.getCard();
                for (Card card : cards) {
                    logger.info("Card ID: " + card.getId());
                    logger.info("Card Number: " + card.getCardNumber());
                    logger.info("Expiration Date: " + card.getExpirationDate());
                }
                List<Loan> loans = account.getLoan();
                for (Loan loan : loans) {
                    logger.info("Loan ID: " + loan.getId());
                    logger.info("Loan Amount: " +loan.getLoanAmount());
                    logger.info("Interest Rate: " + loan.getInterestRate());
                    logger.info("Loan Duration: " + loan.getLoanDuration());
                }
            }
            }catch( JAXBException e){
                logger.error("Error occurred",e);
            }
            return customer;
        }
    }
