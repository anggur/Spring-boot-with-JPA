package com.mbb.jpa.service;

import com.mbb.jpa.entities.Address;
import com.mbb.jpa.entities.Employee;
import com.mbb.jpa.model.EmployeeVo;
import com.mbb.jpa.respositories.EmployeeRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {EmployeeServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceImplTest {
    @MockBean
    private AddressService addressService;
    
    @MockBean
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    
    /**
     * Method under test: {@link EmployeeServiceImpl#addEmployee(EmployeeVo)}
     */
    @Test
    public void testAddEmployee_SUCCESS() {
        doNothing().when(addressService).addAddress(Mockito.any());
        
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Name");
        when(employeeRepository.save(Mockito.any())).thenReturn(employee);
        assertSame(employee, employeeServiceImpl.addEmployee(new EmployeeVo("Name", "42 Main St")));
        verify(addressService).addAddress(Mockito.any());
        verify(employeeRepository).save(Mockito.any());
    }
    
    /**
     * Method under test: {@link EmployeeServiceImpl#addEmployee(EmployeeVo)}
     */
    @Test
    public void testAddEmployee2_SUCCESS() {
        doNothing().when(addressService).addAddress(Mockito.any());
        
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Name");
        when(employeeRepository.save(Mockito.any())).thenReturn(employee);
        assertNull(employeeServiceImpl.addEmployee(null));
    }
    
    /**
     * Method under test: {@link EmployeeServiceImpl#listEmployee(Employee)}
     */
    @Test
    public void testListEmployee_SUCCESS() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        when(employeeRepository.findAllByName(Mockito.any(), Mockito.any())).thenReturn(employeeList);
        
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Name");
        List<Employee> actualListEmployeeResult = employeeServiceImpl.listEmployee(employee);
        assertSame(employeeList, actualListEmployeeResult);
        assertTrue(actualListEmployeeResult.isEmpty());
        verify(employeeRepository).findAllByName(Mockito.any(), Mockito.any());
    }
    
    /**
     * Method under test: {@link EmployeeServiceImpl#listEmployeeFromExtApi(Employee)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testListEmployeeFromExtApi2_SUCCESS() {

        Employee employee = new Employee(1, "UUU://UU@[99UU]:{UUUUU?UU#xx");
        employee.setId(1);
        employee.setName("Name");
        employeeServiceImpl.listEmployeeFromExtApi(employee);
    }

}

