package com.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.IAppointmentRepository;
import com.car.dao.ICarRepository;
import com.car.dao.ICustomerRepository;
import com.car.dao.IOrderRepository;
import com.car.exception.NoCustomerFound;
import com.car.models.Appointment;
import com.car.models.Car;
import com.car.models.Customer;
import com.car.models.Order;

import java.util.List;


@Service
public class CustomerserviceImpl implements ICustomerService{

	

	    @Autowired
        ICustomerRepository customerRepository;
	    
	    @Autowired
	    IAppointmentRepository aippo;
	    
	    @Autowired
	    ICarRepository carrepo;
	    
	    @Autowired
	    IOrderRepository orderrepo;


	    public List<Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    public Customer getCustomer(String userId) {
	        
	        return customerRepository.findByUserId(userId);
	    }


	    public Customer addCustomer(Customer customer) {
	        return customerRepository.save(customer);
	    }

	    public Customer updateCustomer(String userId, Customer customer) {
	    	Customer c = customerRepository.findByUserId(userId);
	    	c.setAddress(customer.getAddress());
	    	c.setAppointments(customer.getAppointments());
	    	c.setContactNo(customer.getContactNo());
	    	c.setDob(customer.getDob());
	    	c.setEmail(customer.getEmail());
	    	c.setName(customer.getName());
	    	return customerRepository.save(c);
	    }

	    public Customer removeCustomer(String userId) {
	    	Customer c = customerRepository.findByUserId(userId);
	    	if(customerRepository.existsById(userId)) {
				List<Appointment> res = aippo.findByCustomerNotNull();
				List<Car> ce= carrepo.findByCustomerNotNull();
				List<Order> o = orderrepo.findByCustomersNotNull();
				for(Appointment r:res) {
					if(r.getCustomer().getUserId().equals(userId)) {
						r.setCustomer(null);
						aippo.save(r);				}
				}
				
				for(Car r:ce) {
					if(r.getCustomer().getUserId().equals(userId)) {
						r.setCustomer(null);
						carrepo.save(r);				}
				}
				for(Order r:o) {
					if(r.getCustomers().getUserId().equals(userId)) {
						r.setCustomers(null);
						orderrepo.save(r);				}
				}
				customerRepository.deleteById(userId);

			}
				else {
					throw new NoCustomerFound();
				}
	    	return c;
			
	    }

		@Override
		public List<Customer> getCustomersByLocation(int pincode) {

			return customerRepository.findByAddressPincode(pincode);
		}

	}

