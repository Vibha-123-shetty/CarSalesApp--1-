package com.car.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.models.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
	

}
