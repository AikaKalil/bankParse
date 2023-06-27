package com.laba.solvd.bank.parsers;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XmlValidatorWithStax {
    //Validate XML file using XSD schema and assigned parser.
    public static boolean validateXMLAgainstXSD(String xmlFilePath, String xsdFilePath) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdFilePath));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(new File(xmlFilePath));
            validator.validate(source);
            return true;
        } catch (SAXException | IOException e) {
            System.out.println("Exception occurred "+e.getMessage());
            return false;
        }
    }
    public static void parseXMLWithStAX(String xmlFilePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(xmlFilePath);
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(fileInputStream);

            while (xmlStreamReader.hasNext()) {
                int event = xmlStreamReader.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    String elementName = xmlStreamReader.getLocalName();
                    System.out.println("Start element: " + elementName);
                } else if (event == XMLStreamConstants.CHARACTERS) {
                    String text = xmlStreamReader.getText().trim();
                    if (!text.isEmpty()) {
                        System.out.println("Text: " + text);
                    }
                } else if (event == XMLStreamConstants.END_ELEMENT) {
                    String elementName = xmlStreamReader.getLocalName();
                    System.out.println("End element: " + elementName);
                }
            }

            xmlStreamReader.close();
            fileInputStream.close();
        } catch (XMLStreamException | IOException e) {
            System.out.println("Exception occurred"+e.getMessage());
        }
    }
}


