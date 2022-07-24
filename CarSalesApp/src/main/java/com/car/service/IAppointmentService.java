package com.car.service;
import java.util.List;

import com.car.models.Appointment;

public interface IAppointmentService {

	public Appointment addAppointment(Appointment appointment);
	public Appointment removeAppointment(long appointmentId); 
	public Appointment updateAppointment(long appointmentId, Appointment appointment);
	public Appointment getAppointment(long appointmentId);
	public List<Appointment> getAllAppointments(); 
	
}