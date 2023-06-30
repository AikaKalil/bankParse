package com.laba.solvd.bank.parsers;
import com.laba.solvd.bank.model.*;
import org.apache.log4j.Logger;
import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class StaxParser implements Parser {
        public static Logger logger = Logger.getLogger(StaxParser.class);
        public Customer parse(String xmlFilePath) throws FileNotFoundException, XMLStreamException {
            Customer customer = null;
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlFilePath));

            while (xmlEventReader.hasNext()) {
                XMLEvent event = xmlEventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    String elementName = startElement.getName().getLocalPart();

                    if ("customer".equals(elementName)) {
                        customer = new Customer();
                        Attribute attribute = startElement.getAttributeByName(new QName("id"));
                        if (attribute != null) {
                            customer.setId(Long.valueOf(attribute.getValue()));
                        }
                    } else if ("firstName".equals(elementName)) {
                        event = xmlEventReader.nextEvent();
                        customer.setFirstName(event.asCharacters().getData());
                    } else if ("lastName".equals(elementName)) {
                        event = xmlEventReader.nextEvent();
                        customer.setLastName(event.asCharacters().getData());
                    } else if ("accounts".equals(elementName)) {
                        customer.setAccount(parseAccounts(xmlEventReader));
                    }

                }

                if (event.isEndElement()) {
                    if ("customer".equals(event.asEndElement().getName().getLocalPart())) {
                        break;
                    }
                }
            }
            printCustomerInfo(customer);
            return customer;
        }

        private List<Account> parseAccounts(XMLEventReader xmlEventReader) throws XMLStreamException {
            List<Account> accounts = new ArrayList<>();
            Account account = null;

            while (xmlEventReader.hasNext()) {
                XMLEvent event = xmlEventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement st = event.asStartElement();
                    String elementName = st.getName().getLocalPart();
                    if ("account".equals(elementName)) {
                        account = new Account();
                        Attribute attribute = st.getAttributeByName(new QName("id"));
                        if (attribute != null) {
                            account.setId(Long.valueOf(attribute.getValue()));
                        }
                    } else if ("accountType".equals(elementName)) {
                        event = xmlEventReader.nextEvent();
                        account.setAccountType(event.asCharacters().getData());
                    } else if ("balance".equals(elementName)) {
                        event = xmlEventReader.nextEvent();
                        account.setBalance(Double.parseDouble(event.asCharacters().getData()));
                    } else if ("transactions".equals(elementName)) {
                        account.setTransaction(parseTransactions(xmlEventReader));
                    } else if ("cards".equals(elementName)) {
                        account.setCard(parseCards(xmlEventReader));
                    } else if ("loans".equals(elementName)) {
                        account.setLoan(parseLoans(xmlEventReader));
                    }
                }
                if (event.isEndElement()) {
                    if ("account".equals(event.asEndElement().getName().getLocalPart())) {
                        accounts.add(account);
                    } else if ("accounts".equals(event.asEndElement().getName().getLocalPart())) {
                        break;
                    }
                }
            }
            return accounts;
        }

        private List<Transaction> parseTransactions(XMLEventReader xmlEventReader) throws XMLStreamException {
            List<Transaction> transactions = new ArrayList<>();
            Transaction transaction = null;

            while (xmlEventReader.hasNext()) {
                XMLEvent event = xmlEventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    String elementName =startElement.getName().getLocalPart();
                    if ("transaction".equals(elementName)) {
                        transaction = new Transaction();
                        Attribute attribute = event.asStartElement().getAttributeByName(new QName("id"));
                        if (attribute != null) {
                            transaction.setId(Long.valueOf(attribute.getValue()));
                        }
                    } else if ("transactionType".equals(elementName)) {
                        event = xmlEventReader.nextEvent();
                        transaction.setTransactionType(event.asCharacters().getData());
                    } else if ("amount".equals(elementName)) {
                        event = xmlEventReader.nextEvent();
                        transaction.setAmount(Double.parseDouble(event.asCharacters().getData()));
                    } else if ("transactionDate".equals(elementName)) {
                        event = xmlEventReader.nextEvent();
                        transaction.setTransactionDate(new Date(event.asCharacters().getData()));
                    }
                }

                if (event.isEndElement() && "transaction".equals(event.asEndElement().getName().getLocalPart())) {
                    transactions.add(transaction);
                } else if (event.isEndElement() && "transactions".equals(event.asEndElement().getName().getLocalPart())) {
                    break;
                }
            }

            return transactions;
        }

        private List<Card> parseCards(XMLEventReader xmlEventReader) throws XMLStreamException {
            List<Card> cards = new ArrayList<>();
            Card card = null;

            while (xmlEventReader.hasNext()) {
                XMLEvent event = xmlEventReader.nextEvent();

                if (event.isStartElement()) {
                    String elementName = event.asStartElement().getName().getLocalPart();
                    if ("card".equals(elementName)) {
                        card = new Card();
                        Attribute idAttribute = event.asStartElement().getAttributeByName(new QName("id"));
                        if (idAttribute != null) {
                            card.setId(Long.valueOf(idAttribute.getValue()));
                        }
                    } else if ("cardNumber".equals(elementName)) {
                        event = xmlEventReader.nextEvent();
                        card.setCardNumber(event.asCharacters().getData());
                    } else if ("expirationDate".equals(elementName)) {
                        event = xmlEventReader.nextEvent();
                        card.setExpirationDate(new Date(event.asCharacters().getData()));
                    }
                }

                if (event.isEndElement() && "card".equals(event.asEndElement().getName().getLocalPart())) {
                    cards.add(card);
                } else if (event.isEndElement() && "cards".equals(event.asEndElement().getName().getLocalPart())) {
                    break;
                }
            }

            return cards;
        }

        private List<Loan> parseLoans(XMLEventReader xmlEventReader) throws XMLStreamException {
            List<Loan> loans = new ArrayList<>();
            Loan loan = null;

            while (xmlEventReader.hasNext()) {
                XMLEvent event = xmlEventReader.nextEvent();

                if (event.isStartElement()) {
                    String elementName = event.asStartElement().getName().getLocalPart();
                    if ("loan".equals(elementName)) {
                        loan = new Loan();
                        Attribute idAttribute = event.asStartElement().getAttributeByName(new QName("id"));
                        if (idAttribute != null) {
                            loan.setId(Long.valueOf(idAttribute.getValue()));
                        }
                    } else if ("loanAmount".equals(elementName)) {
                        event = xmlEventReader.nextEvent();
                        loan.setLoanAmount(Double.parseDouble(event.asCharacters().getData()));
                    } else if ("interestRate".equals(elementName)) {
                        event = xmlEventReader.nextEvent();
                        loan.setInterestRate(Double.parseDouble(event.asCharacters().getData()));
                    } else if ("loanDuration".equals(elementName)) {
                        event = xmlEventReader.nextEvent();
                        loan.setLoanDuration(event.asCharacters().getData());
                    }
                }

                if (event.isEndElement() && "loan".equals(event.asEndElement().getName().getLocalPart())) {
                    loans.add(loan);
                } else if (event.isEndElement() && "loans".equals(event.asEndElement().getName().getLocalPart())) {
                    break;
                }
            }

            return loans;
        }

        private void printCustomerInfo(Customer customer) {
            if (customer != null) {
                logger.info("Customer ID: " + customer.getId());
                logger.info("First Name: " + customer.getFirstName());
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
            }
        }
    }