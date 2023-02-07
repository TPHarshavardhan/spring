package com.springrest.springrest.controller;

import com.springrest.springrest.etities.EmployeeDTO;
import com.springrest.springrest.pojo.Employee;
import com.springrest.springrest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
@RestController

public class MyController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/emp")
    public List<Employee> getEmployees() throws ParseException {
        return this.employeeService.getEmployees();
    }
    @GetMapping("/emp/{empId}")
    public Employee getEmployee(@PathVariable("empId") long empId){
        return this.employeeService.getEmployee(empId);
    }
    @PostMapping("/createEmployee")
    public String addEmployee(@RequestBody Employee employee) throws ParseException {
            return this.employeeService.addEmployee(employee);
    }
    @GetMapping("/findSeniorEmployee")
    public  Employee findSenior(){return this.employeeService.getSenior();}

//    @PutMapping("/updating")
//    public EmployeeDTO updateEmployee(EmployeeDTO employee){
//        Employee employee1=new Employee();
//        employee1.setEmpId(employee.getEmpId());
//        return this.employeeService.updateEmployee(employee1.getEmpId());
//    }

}
