package com.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.models.Order;
import com.car.service.IOrderService;

@RestController
public class OrderController {
	
	@Autowired
	IOrderService oderservice;
	
	@GetMapping("/allorders")
	public List<Order> getAllOrders() {
		return oderservice.getAllOrders();
		
	}
	@GetMapping("/order/{id}")
	public Order  getOrderDetails(@PathVariable("id") long id) {
		return oderservice.getOrderDetails(id);
	}
	
	@PostMapping(value="/addorder",consumes = "application/json")
	public String addOrder(@RequestBody Order order) {
		
		oderservice.addOrder(order);
		return "Ordered successfully";
	}
	
	@DeleteMapping("/order/delete/{id}")
	public String removeOrder(@PathVariable("id") long id) {
		oderservice.removeOrder(id);
		return "Deleted successfully";
	}
	
	@PutMapping(value="/order/update",consumes = "application/json")
	public String  updateOrder(@PathVariable("orderid") long orderid,@RequestBody Order order) {
		oderservice.updateOrder(orderid, order);
		return "Updated successfully";
		
	}





}
