package com.car.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.models.*;
import com.car.service.IUserService;

@RestController
public class LoginController {
	@Autowired
	IUserService cred;
	
	@PostMapping(value="/car/login")
	public String loginUser(@RequestBody User user) {
		
	     cred.signIn(user);
	     return"Login successfully";
	}


	@PostMapping("/car/logout")
	public String logUserOut(@RequestBody User login) {
	   cred.signOut(login);
	   
	   return "logout successfully";
	}

	@PutMapping(path="/car/changepassword/{id}")
	public String ChangePassword(@PathVariable("id") String id,@RequestBody User login) {
		cred.changePassword(id, login);
		
		return "Updated successfully";
	}
	   
}
