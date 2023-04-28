package com.mbb.mbproject.service;

import com.mbb.mbproject.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbb.mbproject.repository.AddressRepository;
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

