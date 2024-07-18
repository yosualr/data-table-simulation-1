package com.simulation.testdatatable.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simulation.testdatatable.models.Customers;

public interface CustomerRepositories extends JpaRepository<Customers, Long> {
    
}
