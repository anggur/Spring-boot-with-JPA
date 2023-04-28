package com.mbb.mbproject.repository;

import com.mbb.mbproject.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
