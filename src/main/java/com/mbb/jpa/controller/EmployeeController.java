package com.mbb.jpa.controller;

import com.mbb.jpa.entities.Employee;
import com.mbb.jpa.model.EmployeeVo;
import com.mbb.jpa.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    
    @Autowired
    private EmployeeService employeeService;
    
    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeVo employeeVo) {
        
        LOGGER.info("Receiving Add Request: " + employeeVo);
        Employee employeeSavedToDB = employeeService.addEmployee(employeeVo);
        return new ResponseEntity<>(employeeSavedToDB, HttpStatus.CREATED);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(@RequestBody Employee employee) {
        LOGGER.info("Receiving List Request: " + employee);
        List<Employee> listEmployee = employeeService.listEmployee(employee);
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }
    
    @GetMapping("/extapi")
    public ResponseEntity<String> getAllEmployeeFromExtApi(@RequestBody Employee employee) {
        LOGGER.info("Receiving List Request: " + employee);
        String listEmployee = employeeService.listEmployeeFromExtApi(employee);
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }
}
