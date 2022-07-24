package com.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.IAppointmentRepository;
import com.car.exception.NoAppointmentFound;
import com.car.models.Appointment;

@Service
public class AppointmentServiceImpl implements IAppointmentService{
	
@Autowired
private IAppointmentRepository iappo;

@Override
public Appointment addAppointment(Appointment appointment) {
	return iappo.save(appointment);
}

@Override
public Appointment removeAppointment(long appointmentId) {
	if(iappo.existsById(appointmentId)) {
	iappo.deleteById(appointmentId);
	}
	else {
		throw new NoAppointmentFound();
	}
	
	return iappo.findByAppointmentId(appointmentId);
}

@Override
public Appointment updateAppointment(long appointmentId, Appointment appointment) {
	Appointment a = iappo.findByAppointmentId(appointmentId);
	a.setCustomer(appointment.getCustomer());
	a.setInspectionType(appointment.getInspectionType());
	a.setLocation(appointment.getLocation());
	a.setPayment(appointment.getPayment());
	a.setPreferredDate(appointment.getPreferredDate());
	a.setPreferredTime(appointment.getPreferredTime());
	return iappo.save(a);
}

@Override
public Appointment getAppointment(long appointmentId) {
	return iappo.findByAppointmentId(appointmentId);
}

@Override
public List<Appointment> getAllAppointments() {
	return iappo.findAll();
}





}
