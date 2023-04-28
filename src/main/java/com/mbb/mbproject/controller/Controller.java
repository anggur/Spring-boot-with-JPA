package com.mbb.mbproject.controller;

import com.mbb.mbproject.entities.Employee;
import com.mbb.mbproject.model.EmployeeVo;
import com.mbb.mbproject.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/employee")
public class Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
    
    @Autowired
    private EmployeeService employeeService;
    
    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeVo employeeVo) {
        
        LOGGER.info("Receiving Add Request: " + employeeVo);
        Employee employeeSavedToDB = employeeService.addEmployee(employeeVo);
        return new ResponseEntity<>(employeeSavedToDB, HttpStatus.CREATED);
    }
    
    @PostMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(@RequestBody Employee employee) {
        LOGGER.info("Receiving List Request: " + employee);
        List<Employee> listEmployee = employeeService.listEmployee(employee);
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }
    
    @PostMapping("/extapi")
    public ResponseEntity<String> getAllEmployeeFromExtApi(@RequestBody Employee employee) throws Exception{
        LOGGER.info("Receiving List Request: " + employee);
        String listEmployee = employeeService.listEmployeeFromExtApi();
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }
}
