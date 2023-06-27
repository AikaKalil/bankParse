package com.laba.solvd.bank;
import org.apache.log4j.Logger;
import static com.laba.solvd.bank.parsers.XmlValidatorWithStax.parseXMLWithStAX;
import static com.laba.solvd.bank.parsers.XmlValidatorWithStax.validateXMLAgainstXSD;


public class Main {

    public static void main(String[] args) {

        String xmlFilePath = "src/main/resources/mapper/bank.xml";
        String xsdFilePath = "src/main/resources/mapper/bank.xsd";
        String jsonFilePath = "src/main/resources/mapper/bank.json";

        boolean isValid = validateXMLAgainstXSD(xmlFilePath, xsdFilePath);
        System.out.println("XML validation result: " + isValid);
        if (isValid) {
            parseXMLWithStAX(xmlFilePath);


        }
    }
}