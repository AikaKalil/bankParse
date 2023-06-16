package com.laba.solvd.bank.dao;

import com.laba.solvd.bank.model.Employees;

import java.util.List;

public interface EmployeesRepository {
    void create(Employees employee,int employeeId);
    List<Employees> findAll();
    void update(Employees employee);

}
