package com.car.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.car.exception.NoPaymentFoundException;
import com.car.models.Payment;
import com.car.service.IPaymentServiceImp;

@RestController
@RequestMapping("CSA/")
public class PaymentController {
	@Autowired
	IPaymentServiceImp payservice;
	
	@PostMapping(path= "pay/add")
	public ResponseEntity<com.car.models.Payment> addNewpayment(@RequestBody Payment payment)
	{
		if(payment == null)
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(payservice.addPayment(payment), HttpStatus.OK);
		
	}
	@DeleteMapping(path= "pay/del/{paymentId}")
	public String deletePaymentById(@PathVariable("paymentId") Long id)
	{
		payservice.removePayment(id);
		return "Deleted successfull";
	}
	@PutMapping(path="pay/update/{paymentId}")
	public ResponseEntity<Payment> updatePaymentById(@PathVariable("paymentId") Long id, @RequestBody Payment payment)
	{
		if(payservice.updatePayment(id, payment) == null)
		{
			throw new NoPaymentFoundException();
		}
		return new ResponseEntity<>(payservice.updatePayment(id, payment), HttpStatus.OK);
	}
	
	
	@GetMapping(path="/allpayments")
	public ResponseEntity<List<Payment>> getAllPayments()
	{
		if(payservice.getAllPaymentDetails().isEmpty())
		{
			throw new NoPaymentFoundException();
		}
		return new ResponseEntity<>(payservice.getAllPaymentDetails(), HttpStatus.OK);	
	}
	
	@GetMapping(path="pay/getbyid/{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("paymentId") Long id)
	{
		if(payservice.getPaymentDetails(id) == null)
		{
			throw new NoPaymentFoundException();
		}
		return new ResponseEntity<>(payservice.getPaymentDetails(id), HttpStatus.OK);
	}
	

}