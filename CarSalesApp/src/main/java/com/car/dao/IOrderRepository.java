package com.car.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.models.Order;


@Repository
public interface IOrderRepository extends JpaRepository<Order, Long>{
	
	Order findByOrderId(long id);
	List<Order> findByPaymentNotNull();
	List<Order> findByCustomersNotNull();

}