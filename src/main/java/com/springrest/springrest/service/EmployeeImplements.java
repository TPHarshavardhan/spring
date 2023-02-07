package com.springrest.springrest.service;

import com.springrest.springrest.customException.BussinessException;
import com.springrest.springrest.dao.EmployeeDao;
import com.springrest.springrest.etities.EmployeeDTO;
import com.springrest.springrest.pojo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

@Service
public class EmployeeImplements implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public List<Employee> getEmployees() {
        List<EmployeeDTO> employeeDTOList= employeeDao.findAll();
        List<Employee> employeeList=new ArrayList<>(employeeDTOList.size());
        for(EmployeeDTO employeeDTO:employeeDTOList){
            Employee employee=new Employee();
            employee.setAge(employeeDTO.getAge());
            employee.setEmpId(employeeDTO.getEmpId());
            employee.setName(employeeDTO.getName());
            employee.setSal(employeeDTO.getSal());
            employee.setDate(employeeDTO.getDate());
            employeeList.add(employee);
        }
        return employeeList;
    }
    @Override
    public Employee getEmployee(long empId) {
        EmployeeDTO employeeDTO= employeeDao.getReferenceById(empId);
        Employee employee=new Employee();
        employee.setAge(employeeDTO.getAge());
        employee.setEmpId(employeeDTO.getEmpId());
        employee.setName(employeeDTO.getName());
        employee.setSal(employeeDTO.getSal());
        employee.setDate(employeeDTO.getDate());
        return employee;
    }
    @Override
    public String addEmployee(Employee employee) throws ParseException,BussinessException {
        EmployeeDTO employeeDTO=new EmployeeDTO();
        employeeDTO.setEmpId(employee.getEmpId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSal(employee.getSal());
        employee.setDate(employeeDTO.getDate());
        //Date date1=new SimpleDateFormat( "dd/mm/yyyy").parse(employee.getDate());
        //employeeDTO.setDate(String.valueOf(date1));
        int age=employee.getAge();
            if ((age > 1) && (age <= 20)) {
                employeeDTO.setStatus("kid");
            } else if ((age > 21) && (age < 60)) {
                employeeDTO.setStatus("adult");
            } else if (age > 60 && age < 100) {
                employeeDTO.setStatus("oldCitizen");
            } else if (age>100) {
                throw new BussinessException("InvalidAge");

            }
        employeeDTO.setAge(employee.getAge());
        employeeDao.save(employeeDTO);
        return "successfully saved" ;
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employee){
        employeeDao.save(employee);
        return  employee;
    }
    @Override
    public Employee getSenior() {
          List<EmployeeDTO> employeeDTOList=employeeDao.findAll();
//        employeeDT OList.sort((Comparator<? super EmployeeDTO>) employeeDTOList.get(1));
//        List<Employee> employeeList=new ArrayList<>();
//          List<Integer> employeeAge=new ArrayList<>(4);
//          Collections.sort(employeeAge);
//          for(EmployeeDTO  employeeDTO:employeeDTOList){
//              if(employeeAge.get(3).equals(employeeDTO.getDate()));
//              Employee employee=new Employee();
//              employee.setAge(employeeDTO.getAge());
//              employee.setEmpId(employeeDTO.getEmpId());
//              employee.setName(employeeDTO.getName());
//              employee.setSal(employeeDTO.getSal());
//              employee.setDate(employeeDTO.getDate());
//              return employee;
//          }
          Collections.sort(employeeDTOList, new Comparator<EmployeeDTO>() {
              @Override
              public int compare(EmployeeDTO o1, EmployeeDTO o2) {
                return o2.getAge()-o1.getAge();
            }
              });
            EmployeeDTO employeeDTO=employeeDTOList.get(0);
            Employee employee=new Employee();
            employee.setAge(employeeDTO.getAge());
            employee.setEmpId((employeeDTO.getEmpId()));
            employee.setName(employeeDTO.getName());
            employee.setSal(employeeDTO.getSal());
            employee.setDate(employeeDTO.getDate());

        return employee;
    }
    public Date getDate(Employee employee){
        return getDate(employee);
    }

}


