package com.mbb.jpa.respositories;

import com.mbb.jpa.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
