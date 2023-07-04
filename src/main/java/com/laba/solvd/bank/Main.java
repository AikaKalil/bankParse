package com.laba.solvd.bank;
import com.laba.solvd.bank.model.Customer;
import com.laba.solvd.bank.parsers.JAXBParser;
import com.laba.solvd.bank.parsers.JacksonParser;
import com.laba.solvd.bank.parsers.Parser;
import com.laba.solvd.bank.parsers.StaxParser;
import com.laba.solvd.bank.validator.XmlValidator;


public class Main {
    public static void main(String[] args) throws Exception {

        String xmlFilePath = "src/main/resources/mapper/bank.xml";
        String xsdFilePath = "src/main/resources/mapper/bank.xsd";
        String jsonFilePath = "src/main/resources/mapper/bank.json";

        XmlValidator.validateXMLAgainstXSD(xmlFilePath, xsdFilePath);

        System.out.println("--JAXBParser----JAXBParser----JAXBParser--");
        Parser parser=new JAXBParser();
        Customer customer=parser.parse(xmlFilePath);
        System.out.println("");
        System.out.println("--StaxParser----StaxParser----StaxParser--");
         parser = new StaxParser();
         customer = parser.parse(xmlFilePath);
        System.out.println("");
        System.out.println("--Jackson Parser----Jackson Parser----Jackson Parser--");
         parser = new JacksonParser();
         customer = parser.parse(jsonFilePath);


    }
}