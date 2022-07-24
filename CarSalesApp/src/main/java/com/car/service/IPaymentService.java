package com.car.service;
import java.util.List;

import com.car.models.Payment;

public interface IPaymentService {
	public Payment addPayment(Payment payment);
	public void removePayment(long id);
	public Payment updatePayment(long id, Payment payment);
	public Payment getPaymentDetails(long id);
	public List<Payment> getAllPaymentDetails();
}
