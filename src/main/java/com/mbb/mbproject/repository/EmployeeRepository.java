package com.mbb.mbproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mbb.mbproject.entities.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findAllByName(String name, Pageable pageable);

}

