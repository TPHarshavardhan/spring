package com.springrest.springrest.dao;

import com.springrest.springrest.etities.EmployeeDTO;
import com.springrest.springrest.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<EmployeeDTO,Long> {
}
