package com.laba.solvd.bank.validator;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlValidator {
    //Validate XML file using XSD schema and assigned parser.
    public static void validateXMLAgainstXSD(String xmlFilePath, String xsdFilePath) {
        try (FileInputStream xmlInputStream = new FileInputStream(xmlFilePath);
             FileInputStream xsdInputStream = new FileInputStream(xsdFilePath)) {

            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(xmlInputStream);

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new StreamSource(xsdInputStream));
            Validator validator = schema.newValidator();
            validator.validate(new StAXSource(xmlStreamReader));
        } catch (SAXException | IOException | XMLStreamException e) {
            System.out.println("Exception occurred " + e.getMessage());
        }
    }
}