package com.car.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.car.models.Customer;
import com.car.service.ICustomerService;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable String id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/customers/location/{pincode}")
    public List<Customer> getCustomersByLocation(@PathVariable int pincode) {
        return customerService.getCustomersByLocation(pincode);
    }

    @PostMapping(value ="/customers/save")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/customers/update/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable String id) {
        return customerService.updateCustomer(id, customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/customers/delete/{id}")
    public Customer deleteCustomer(@PathVariable String id) {
        return customerService.removeCustomer(id);
    }
}