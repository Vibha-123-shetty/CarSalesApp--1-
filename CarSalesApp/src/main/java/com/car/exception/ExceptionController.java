package com.car.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = AppointmentNotFound.class)
	public ResponseEntity<Object> exception(AppointmentNotFound exception) {

	   return new ResponseEntity<Object>("Appointment not found", HttpStatus.NOT_FOUND);

	  }
	
	@ExceptionHandler(value = CarNotFoundException.class)
	 public ResponseEntity<Object> exception(CarNotFoundException exception) {

		   return new ResponseEntity<>("Sorry! Requested Car Not Found!", HttpStatus.NOT_FOUND);

		  }
	 
	 @ExceptionHandler(value = NoCarsException.class)
	 public ResponseEntity<Object> exception(NoCarsException exception) {

		   return new ResponseEntity<>("No car is registered yet!!", HttpStatus.NOT_FOUND);

		  }
	 
	 @ExceptionHandler(value = NoPaymentFoundException.class)
	 public ResponseEntity<Object> exception(NoPaymentFoundException exception) {

		   return new ResponseEntity<>("No Payment is there !!", HttpStatus.NOT_FOUND);

		  }
	 
	 @ExceptionHandler(value = NoOrderFoundException.class)
	 public ResponseEntity<Object> exception(NoOrderFoundException exception) {

		   return new ResponseEntity<>("No Order is Found !!", HttpStatus.NOT_FOUND);

		  }
	 
	 @ExceptionHandler(value = NoAppointmentFound.class)
	 public ResponseEntity<Object> exception(NoAppointmentFound exception) {

		   return new ResponseEntity<>("No Appointment is Found !!", HttpStatus.NOT_FOUND);

		  }
	 
	 @ExceptionHandler(value = NoCustomerFound.class)
	 public ResponseEntity<Object> exception(NoCustomerFound exception) {

		   return new ResponseEntity<>("No Customer is Found !!", HttpStatus.NOT_FOUND);

		  }

}
