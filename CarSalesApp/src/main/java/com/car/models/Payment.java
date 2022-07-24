package com.car.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name= "payments")
public class Payment {
	@Id
	private long paymentId;
	private String type;
	private String status;
	
	
	
	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Appointment getAppointments() {
		return appointments;
	}

	public void setAppointments(Appointment appointments) {
		this.appointments = appointments;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	@OneToOne
	@JoinColumn(name="card_id")
	private Card card;
	
	@OneToOne(mappedBy = "payment")
	@JsonIgnore
	private Appointment appointments;
	
	@OneToOne(mappedBy = "payment")
	@JsonIgnore
	private Order orders;
}
