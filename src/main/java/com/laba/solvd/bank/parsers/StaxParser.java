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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class StaxParser implements Parser {
        public static Logger logger = Logger.getLogger(StaxParser.class);
        public Customer parse(String xmlFilePath) throws Exception {
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

        private List<Account> parseAccounts(XMLEventReader xmlEventReader) throws Exception {
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

        private List<Transaction> parseTransactions(XMLEventReader xmlEventReader) throws XMLStreamException,ParseException {
            List<Transaction> transactions = new ArrayList<>();
            Transaction transaction = null;

            while (xmlEventReader.hasNext()) {
                XMLEvent event = xmlEventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    String elementName = startElement.getName().getLocalPart();
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
                        String dateString = event.asCharacters().getData();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                        Date transactionDate = dateFormat.parse(dateString);
                        transaction.setTransactionDate(transactionDate);
                    }
                }

                if (event.isEndElement()) {
                    if ("transaction".equals(event.asEndElement().getName().getLocalPart())) {
                        transactions.add(transaction);
                    } else if ("transactions".equals(event.asEndElement().getName().getLocalPart())) {
                        break;
                    }
                }
            }
            return transactions;
        }

    private List<Card> parseCards(XMLEventReader xmlEventReader) throws XMLStreamException, ParseException {
        List<Card> cards = new ArrayList<>();
        Card card = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

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
                    String dateString = event.asCharacters().getData();
                    Date expirationDate = dateFormat.parse(dateString);
                    card.setExpirationDate(expirationDate);
                }
            }

            if (event.isEndElement()) {
                if ("card".equals(event.asEndElement().getName().getLocalPart())) {
                    cards.add(card);
                } else if ("cards".equals(event.asEndElement().getName().getLocalPart())) {
                    break;
                }
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

                if (event.isEndElement()) {
                    if ("loan".equals(event.asEndElement().getName().getLocalPart())) {
                        loans.add(loan);
                    } else if ("loans".equals(event.asEndElement().getName().getLocalPart())) {
                        break;
                    }
                }
            }

            return loans;
        }

    public void printCustomerInfo(Customer customer) {
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("First Name: " + customer.getFirstName());
        System.out.println("Last Name: " + customer.getLastName());

        List<Account> accounts = customer.getAccount();
        System.out.println("Accounts:");
        for (Account account : accounts) {
            System.out.println("Account ID: " + account.getId());
            System.out.println("Account Type: " + account.getAccountType());
            System.out.println("Balance: " + account.getBalance());

            List<Transaction> transactions = account.getTransaction();
            System.out.println("Transactions:");
            for (Transaction transaction : transactions) {
                System.out.println("Transaction ID: " + transaction.getId());
                System.out.println("Transaction Type: " + transaction.getTransactionType());
                System.out.println("Amount: " + transaction.getAmount());
                System.out.println("Transaction Date: " + transaction.getTransactionDate());
            }

            List<Card> cards = account.getCard();
            System.out.println("Cards:");
            for (Card card : cards) {
                System.out.println("Card ID: " + card.getId());
                System.out.println("Card Number: " + card.getCardNumber());
                System.out.println("Expiration Date: " + card.getExpirationDate());

//                CardType cardType = card.getCardType();
//                System.out.println("Card Type ID: " + cardType.getId());
//                System.out.println("Credit: " + cardType.getCredit());
//                System.out.println("Debit: " + cardType.getDebit());
            }

            List<Loan> loans = account.getLoan();
            System.out.println("Loans:");
            for (Loan loan : loans) {
                System.out.println("Loan ID: " + loan.getId());
                System.out.println("Loan Amount: " + loan.getLoanAmount());
                System.out.println("Interest Rate: " + loan.getInterestRate());
                System.out.println("Loan Duration: " + loan.getLoanDuration());
            }
        }
    }


}