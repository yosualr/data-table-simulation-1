package com.simulation.testdatatable.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simulation.testdatatable.dtos.BatchOperationDTO;
import com.simulation.testdatatable.services.CustomerServices;

@RestController
@RequestMapping("/api/customers")
public class CustomersControllers {
    
    @Autowired
    private CustomerServices customerServices;

    @PostMapping("/batch")
    public ResponseEntity<List<String>> processBatchOperation(@RequestBody BatchOperationDTO batchOperation) {
        List<String> responses = customerServices.processBatchOperation(batchOperation);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/list")
    public ResponseEntity<Void> getDataCustomers() {
        customerServices.getAllEmployees();
        return ResponseEntity.ok().build();
    }
}
