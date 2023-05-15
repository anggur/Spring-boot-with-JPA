package com.mbb.jpa.service;

import com.mbb.jpa.entities.Address;
import com.mbb.jpa.respositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "AddressService")
@Transactional
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    
    @Override
    public void addAddress(Address address) {
        Address addressSavedToDB = this.addressRepository.save(address);
    }
    
}
