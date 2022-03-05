package com.jumia.service;

import java.util.List;
import java.util.Map;

import com.jumia.ResourceNotFoundException;
import com.jumia.model.Customer;

import org.springframework.http.ResponseEntity;

public interface ICustomerService {
    public ResponseEntity<List<Customer>> getAllCustomers();

    public Customer addCustomer(Customer customer);

    public ResponseEntity<Customer> getCustomerById(Integer customerId)
            throws ResourceNotFoundException;

    public Map<String, Boolean> deleteCustomer(Integer customerId)
            throws ResourceNotFoundException;

    public ResponseEntity<Customer> updateCustomer(Integer customerId, Customer customerDetails)
            throws ResourceNotFoundException;

}
