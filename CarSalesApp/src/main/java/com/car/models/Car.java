package com.car.models;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.Data;

@Table(name = "cars")
@Entity
@Data
public class Car {
	
	@Id
	@Column(name = "CarID")
	private long carId;
	
	@Column(name = "Brand")
	private String brand;
	
	@Column(name = "Model")
	private String model;
	
	@Column(name = "Variant")
	private String variant;
	
	@Column(name = "Registration_Year")
	private LocalDate registrationYear;
	
	@Column(name = "Registration_State")
	private String registrationState;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private Customer customer;

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public LocalDate getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(LocalDate registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getRegistrationState() {
		return registrationState;
	}

	public void setRegistrationState(String registrationState) {
		this.registrationState = registrationState;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}