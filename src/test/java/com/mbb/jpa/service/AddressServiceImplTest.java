package com.mbb.jpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mbb.jpa.entities.Address;
import com.mbb.jpa.entities.Employee;
import com.mbb.jpa.respositories.AddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AddressServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AddressServiceImplTest {
    @MockBean
    private AddressRepository addressRepository;
    
    @Autowired
    private AddressServiceImpl addressServiceImpl;
    
    /**
     * Method under test: {@link AddressServiceImpl#addAddress(Address)}
     */
    @Test
    public void testAddAddress_SUCCESS() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Name");
        
        Address address = new Address();
        address.setAddress("42 Main St");
        address.setEmployee(employee);
        address.setId(1L);
        when(addressRepository.save(Mockito.any())).thenReturn(address);
        
        Employee employee2 = new Employee();
        employee2.setId(1);
        employee2.setName("Name");
        
        Address address2 = new Address();
        address2.setAddress("42 Main St");
        address2.setEmployee(employee2);
        address2.setId(1L);
        addressServiceImpl.addAddress(address2);
        verify(addressRepository).save(Mockito.any());
        assertEquals("42 Main St", address2.getAddress());
        assertEquals(1L, address2.getId().longValue());
        assertSame(employee2, address2.getEmployee());
    }
}

