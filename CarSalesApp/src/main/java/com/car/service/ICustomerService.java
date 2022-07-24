package com.car.service;
import java.util.List;

import com.car.models.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer removeCustomer(String userId);
	public Customer updateCustomer(String userId, Customer customer);
	public Customer getCustomer(String userId);
	public List<Customer> getAllCustomers(); 
	public List<Customer> getCustomersByLocation(int pincode);
}
