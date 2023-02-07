package com.springrest.springrest.service;

import com.springrest.springrest.customException.BussinessException;
//import com.springrest.springrest.dao.EmployeeDao;
import com.springrest.springrest.etities.EmployeeDTO;
import com.springrest.springrest.pojo.Employee;
//import com.zaxxer.hikari.util.FastList;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class EmployeeImplementsTest {
    @Mock
//    private EmployeeDao employeeDao;
    @InjectMocks
    private EmployeeImplements employeeImplements;
    List<EmployeeDTO> employeeDTOList;
    @Test
    void getEmployees(){
        //we use this method in the  createEmployee() in down because
        // we won't access the database, so we create a dummy employee ourselves
        employeeDTOList=new ArrayList<>();
        EmployeeDTO employeeDTO=new EmployeeDTO();
        employeeDTO.setName("harsha");
        employeeDTOList.add(employeeDTO);
    }

    @Test
    void createEmployee() throws ParseException {
        //changes
        // Mockito.doNothing(employeeDao).save();
        //Mockito.doNothing(employeeDao.save(Mockito.any()));
        Employee employee=new Employee();
        employee.setDate("01-02-2023");
        employee.setAge(10);
        employee.setEmpId(1);
        employee.setName("harsha");
        employee.setSal(20000.0);
        assertEquals("successfully saved",employeeImplements.addEmployee(employee));
    }
    @Test
    void createEmployeeAdult() throws ParseException {
        Employee employee=new Employee();
        employee.setName("harsha");
        employee.setDate("02-03-2023");
        employee.setSal(10000.0);
        employee.setEmpId(23);
        employee.setAge(44);
        assertEquals("successfully saved",employeeImplements.addEmployee(employee));
    }
    @Test
    void createEmployeeOldCitezen() throws ParseException {
        //adding changes
        Employee employee=new Employee();
        employee.setName("harsha");
        employee.setDate("02-03-2023");
        employee.setSal(10000.0);
        employee.setEmpId(25);
        employee.setAge(66);
        assertEquals("successfully saved",employeeImplements.addEmployee(employee));
    }
    @Test
    void toFindSeniorEmployee(){
        List<Employee> employeeDTOList1List=new ArrayList<>();
        Employee employee=new Employee();
        employee.setAge(30);
        employeeDTOList1List.add(employee);
        assertNotNull(employeeDTOList1List);
//        Employee employee1=new Employee();
//        employee1.setAge(30);
        assertEquals(employeeDTOList1List.get(0).getAge(), employee.getAge());
//        Mockito.when(employeeDao.findAll()).thenReturn(employeeDTOList);
    }
    @Test
    void createEmployeeException() {
        // Mockito.doNothing(employeeDao).save();
        //Mockito.doNothing(employeeDao.save(Mockito.any()));
        Employee employee = new Employee();
        employee.setDate("01-02-2023");
        employee.setAge(111);
        employee.setEmpId(11);
        employee.setName("harsha");
        employee.setSal(20000.0);
        Exception exception = assertThrows(BussinessException.class, () -> {
            employeeImplements.addEmployee(employee);
        });
        String expectedMessage = "InvalidAge";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void updateEmployee() {

    }
}