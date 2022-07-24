package com.car.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.car.models.Payment;


public interface IPaymentRepository extends JpaRepository<Payment, Long> {
	Payment findByPaymentId(long id);
}
