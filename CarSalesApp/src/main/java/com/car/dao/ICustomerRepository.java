package com.car.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.models.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, String>{

	
	List <Customer>  findByAddressPincode(int pincode);
    public Customer findByUserId(String userId);

}