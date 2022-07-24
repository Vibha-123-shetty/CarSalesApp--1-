package com.car.service;
import com.car.models.User;

public interface IUserService {
	public String signIn(User user);
	public String signOut(User user);
	public String changePassword(String id, User user);

}
