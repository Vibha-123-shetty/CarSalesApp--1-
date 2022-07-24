package com.car.models;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name ="customers")
public class Customer {
	
	@Id
	private String userId;
	private String name;
	private String email;
	private String contactNo;
	private LocalDate dob;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="doorNo", column=@Column(name="Customer_doorno")),
		@AttributeOverride(name="street", column=@Column(name="Customer_street")),
		@AttributeOverride(name="area", column=@Column(name="Customer_area")),
		@AttributeOverride(name="city", column=@Column(name="Customer_city")),
		@AttributeOverride(name="state", column=@Column(name="Customer_state")),
		@AttributeOverride(name="pincode", column=@Column(name="pincode")),

	})
	private Address address;
	
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Appointment> appointments;

	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Car> cars;
	
	@OneToMany(mappedBy = "customers")
	@JsonIgnore
	private List<Order> order;
	
	@OneToOne(mappedBy = "customer")
	@JsonIgnore
	private User user;
	
	
}
