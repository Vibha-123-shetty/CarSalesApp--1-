package com.car.service;
import java.util.List;

import com.car.models.Order;

public interface IOrderService {
	
	public Order addOrder(Order order);
	public void removeOrder(long id);
	public Order  updateOrder(long id, Order order);
	public Order  getOrderDetails(long id);
	public List<Order> getAllOrders(); 

}
