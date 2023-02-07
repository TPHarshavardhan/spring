package com.springrest.springrest.service;

import com.springrest.springrest.etities.EmployeeDTO;
import com.springrest.springrest.pojo.Employee;

import java.text.ParseException;
import java.util.List;

public interface  EmployeeService {
    public List<Employee> getEmployees() throws ParseException;
     public Employee getEmployee(long empId);
    public String addEmployee(Employee employee) throws ParseException;
    public EmployeeDTO updateEmployee(EmployeeDTO employee);

    public Employee getSenior();
}
