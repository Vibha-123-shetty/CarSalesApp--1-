package com.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.car.dao.IUserRepository;
import com.car.models.User;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserRepository userrepo;
	
	@Override
	public String signIn(User user) {
		List<User> users = userrepo.findAll();
	     for (User cb : users) {
	    	if (cb.getUserId().equals(user.getUserId()) && cb.getPassword().equals(user.getPassword())) 
	        {
	        	if(cb.getLoginStatus()==0)
	        	{
	        		cb.setLoginStatus(1);
	        	}
	            userrepo.save(cb);
	            return "Login successfully";
	        }
	    	}
	    	return "Username or password is incorrect";
	     
	}

	@Override
	public String signOut(User user) {
		 List<User> users = userrepo.findAll();
		    for (User cb : users) {
		    	if (cb.getUserId().equals(user.getUserId()) && cb.getPassword().equals(user.getPassword())) 
		        {
		        	if(cb.getLoginStatus()==1)
		        	{
		        		cb.setLoginStatus(0);
		        	}
		            userrepo.save(cb);
		            return "Logout_Successfully";
		        }
		    }
		    return "Error logging out!!";
	}

	@Override
	public String changePassword(String id, User user) {
		List<User> users = userrepo.findAll();
	    for (User cb : users) {
	    	if (cb.getUserId().equals(user.getUserId())) 
	        {
	         		cb.setPassword(user.getPassword());
	        		userrepo.save(cb);
	        }
	            
	            return "Updated_successfully";
	    }
	    
	    return "Error updating the password!!";   
		}	
	}
	


