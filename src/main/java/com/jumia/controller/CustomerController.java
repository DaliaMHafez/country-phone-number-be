package com.jumia.controller;

import com.jumia.ResourceNotFoundException;
import com.jumia.model.Customer;
import com.jumia.service.CustomerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Integer customerId)
            throws ResourceNotFoundException {
        return customerService.getCustomerById(customerId);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Integer customerId,
                                                   @RequestBody Customer customerDetails) throws ResourceNotFoundException {
        return customerService.updateCustomer(customerId, customerDetails);
    }

    @DeleteMapping("/customers/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Integer customerId)
            throws ResourceNotFoundException {
        return customerService.deleteCustomer(customerId);
    }
}

