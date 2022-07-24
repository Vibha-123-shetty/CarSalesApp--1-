package com.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.exception.AppointmentNotFound;
import com.car.models.Appointment;
import com.car.service.IAppointmentService;



@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	
@Autowired
IAppointmentService aservice;

@GetMapping(value="/appointment/byid/{appointmentId}")
public Appointment getAppointment(@PathVariable("appointmentId") long appointmentId ) {
	if(aservice.getAppointment(appointmentId)==null) {
		System.out.println("No appointments is scheduled");
		throw new AppointmentNotFound();
	}
	return aservice.getAppointment(appointmentId);
}

@GetMapping(value="/appointment/findall")
public List<Appointment> getAllAppointments() {
		if(aservice.getAllAppointments().isEmpty()) {
			System.out.println("No Appointments is available");
			throw new AppointmentNotFound();
		}
		return aservice.getAllAppointments();
}
@PostMapping(value="/appointment/save",consumes = "application/json")
public String addAppointment(@RequestBody Appointment appointment) {
	aservice.addAppointment(appointment);
	 return "Added Successfully";
	
}
@PutMapping(value="/appointment/update/{appointmentId}")
public Appointment updateAppointment(@PathVariable("appointmentId") long appointmentId,@RequestBody Appointment appointment) {
	return aservice.updateAppointment(appointmentId, appointment);
}
@DeleteMapping(value="/appointment/delete/{appointmentId}")
public String removeAppointment(@PathVariable("appointmentId") long appointmentId) {
	
	aservice.removeAppointment(appointmentId);	
	
	return "Deleted Successfully";
}
} 
