package com.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.IOrderRepository;
import com.car.exception.NoOrderFoundException;
import com.car.models.Order;

@Service
public class OrderServiceImpl implements IOrderService{

	
	@Autowired
	private IOrderRepository orderrepo;
	
	
	@Override
	public Order addOrder(Order order) {
		return orderrepo.save(order);
	}

	@Override
	public void removeOrder(long id) {
		if(orderrepo.existsById(id)) {
		orderrepo.deleteById(id);
		}
		else {
			throw new NoOrderFoundException();
		}
		
	}

	@Override
	public Order updateOrder(long id, Order order) {
		
		Order o = orderrepo.findByOrderId(id);
		o.setAmount(order.getAmount());
		o.setBillingDate(order.getBillingDate());
		o.setCustomers(order.getCustomers());
		o.setPayment(order.getPayment());
		o.setPaymentMethod(order.getPaymentMethod());
		return orderrepo.save(o); 
	}

	@Override
	public Order getOrderDetails(long id) {
		return orderrepo.findByOrderId(id);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderrepo.findAll();
	}

}
