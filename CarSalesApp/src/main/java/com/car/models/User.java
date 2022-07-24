package com.car.models;



import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	
	@Id
	private String userId;
	private String password;
	private String role;
	private int loginStatus;
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof User)) return false;
	    User user = (User) o;
	    return Objects.equals(userId, user.userId) &&
	            Objects.equals(password, user.password);
	}
	@Override
	public int hashCode() {
	    return Objects.hash(userId, password, role,loginStatus
	                      );
	    
	
	}
	@OneToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "userId", referencedColumnName = "admin")
	private Admin admin;
	

}