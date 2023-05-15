package com.mbb.jpa.service;

import com.mbb.jpa.entities.Employee;
import com.mbb.jpa.model.EmployeeVo;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(EmployeeVo employee);
    
    List<Employee> listEmployee(Employee employee);
    
    String listEmployeeFromExtApi(Employee employee);
}
