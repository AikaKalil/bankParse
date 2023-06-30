package com.laba.solvd.bank;

import com.laba.solvd.bank.model.Customer;
import com.laba.solvd.bank.parsers.JAXBParser;
import com.laba.solvd.bank.parsers.JacksonParser;
import com.laba.solvd.bank.parsers.Parser;
import com.laba.solvd.bank.parsers.StaxParser;
import com.laba.solvd.bank.validator.XmlValidator;
import jakarta.xml.bind.JAXBException;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

        String xmlFilePath = "src/main/resources/mapper/bank.xml";
        String xsdFilePath = "src/main/resources/mapper/bank.xsd";
        String jsonFilePath = "src/main/resources/mapper/bank.json";

        XmlValidator.validateXMLAgainstXSD(xmlFilePath, xsdFilePath);


        //Parser parser=new JAXBParser();
        //Customer customer=parser.parse(xmlFilePath);

        //Parser parser = new staxParser();
        //Customer customer = parser.parse(xmlFilePath);

        Parser parser = new JacksonParser();
        Customer customer = parser.parse(jsonFilePath);


    }
}