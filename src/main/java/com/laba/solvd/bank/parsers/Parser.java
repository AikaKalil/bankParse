package com.laba.solvd.bank.parsers;

import com.laba.solvd.bank.model.Customer;
import jakarta.xml.bind.JAXBException;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

public interface Parser {
    Customer parse(String filePath) throws FileNotFoundException, XMLStreamException;

}
