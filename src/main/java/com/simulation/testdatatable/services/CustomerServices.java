package com.simulation.testdatatable.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulation.testdatatable.dtos.BatchOperationDTO;
import com.simulation.testdatatable.models.Customers;
import com.simulation.testdatatable.repositories.CustomerRepositories;

@Service
public class CustomerServices {
    @Autowired
    CustomerRepositories customerRepositories;

    public List<Customers> getAllEmployees() {
        return customerRepositories.findAll();
    }
    
    public synchronized List<String> processBatchOperation(BatchOperationDTO batchOperation) {
        List<String> responses = new ArrayList<>();

        if (batchOperation.getCreateRequests() != null && !batchOperation.getCreateRequests().isEmpty()) {
            List<Customers> createEntities = batchOperation.getCreateRequests().stream()
                .map(request -> new Customers(null, request.getCustomerName(), request.getCustomerCity()))
                .collect(Collectors.toList());
            customerRepositories.saveAll(createEntities);
            responses.add("Created " + createEntities.size() + " customers.");
        }

        if (batchOperation.getUpdateRequests() != null && !batchOperation.getUpdateRequests().isEmpty()) {
            List<Customers> updateEntities = batchOperation.getUpdateRequests().stream()
                .map(request -> new Customers(request.getCustomerId(), request.getCustomerName(), request.getCustomerCity()))
                .collect(Collectors.toList());
            customerRepositories.saveAll(updateEntities);
            responses.add("Updated " + updateEntities.size() + " customers.");
        }

        if (batchOperation.getDeleteRequests() != null && !batchOperation.getDeleteRequests().isEmpty()) {
            customerRepositories.deleteAllById(batchOperation.getDeleteRequests());
            responses.add("Deleted " + batchOperation.getDeleteRequests().size() + " customers.");
        }

        return responses;
    }
}
