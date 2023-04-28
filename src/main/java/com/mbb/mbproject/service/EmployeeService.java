package com.mbb.mbproject.service;

import com.mbb.mbproject.entities.Employee;
import com.mbb.mbproject.model.EmployeeVo;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(EmployeeVo employee);
    
    List<Employee> listEmployee(Employee employee);
    String listEmployeeFromExtApi();
}
