package com.laba.solvd.bank.parsers;

import com.laba.solvd.bank.model.Customer;

public interface Parser {
    Customer parse(String filePath) throws Exception;

}
