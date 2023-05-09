package com.mbb.mbproject.service;

import com.mbb.mbproject.entities.Address;
import com.mbb.mbproject.entities.Employee;
import com.mbb.mbproject.model.EmployeeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbb.mbproject.repository.EmployeeRepository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service(value = "EmployeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private AddressService addressService;
    
    @Value("${ext.api}/all")
    private String ApiEndpoint;
    @Override
    public Employee addEmployee(EmployeeVo employeeVo)  {
        Employee employeeSavedToDB = null;
        try {
            LOGGER.info("Adding employee " + employeeVo);
            Employee employee = new Employee();
            employee.setName(employeeVo.getName());
            
            employeeSavedToDB = employeeRepository.save(employee);
            
            Address address = new Address();
            address.setAddress(employeeVo.getAddress());
            address.setEmployee(employee);
            
            addressService.addAddress(address);
            LOGGER.info("Adding employee Success");
            
        } catch (Exception e) {
            LOGGER.error("Error while creating employee: " + e);
        }
        return employeeSavedToDB;}
    
    @Override
    public List<Employee> listEmployee(Employee employee) {
        LOGGER.info("Getting employee list");
        if (Objects.isNull(employee)) {
            LOGGER.warn("employee is empty");
            return null;
        }
        Pageable pageRequest = PageRequest.of(0, 10);
        List<Employee> listEmployee = this.employeeRepository.findAllByName(employee.getName(),pageRequest);
        LOGGER.info("Getting employee list success");
        return listEmployee;
    }
    
    @Override
    public String listEmployeeFromExtApi(Employee employee) {
        LOGGER.info("Getting employee list using nested API");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(ApiEndpoint, String.class);
        LOGGER.info("Getting employee list from nested API success");
        return result;
    }
}


