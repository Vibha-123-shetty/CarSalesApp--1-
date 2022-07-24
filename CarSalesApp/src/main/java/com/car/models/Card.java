package com.car.models;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
@Table(name= "cards")
public class Card {
	
	@Id
	private long id;
	private String bankName;
	private String cardName;
	private String cardNumber;
    private LocalDate cardExpiry;
    private int cvv;
    
    
    
    
    public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getBankName() {
		return bankName;
	}




	public void setBankName(String bankName) {
		this.bankName = bankName;
	}




	public String getCardName() {
		return cardName;
	}




	public void setCardName(String cardName) {
		this.cardName = cardName;
	}




	public String getCardNumber() {
		return cardNumber;
	}




	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}




	public LocalDate getCardExpiry() {
		return cardExpiry;
	}




	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}




	public int getCvv() {
		return cvv;
	}




	public void setCvv(int cvv) {
		this.cvv = cvv;
	}




	public List<Payment> getPayment() {
		return payment;
	}




	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}




	@OneToMany(mappedBy = "card")
    @JsonIgnore
    private List<Payment> payment;
}