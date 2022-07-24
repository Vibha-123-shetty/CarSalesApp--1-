package com.car.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.models.Car;


public interface ICarRepository extends JpaRepository<Car, Long> {
	
	List<Car> findByRegistrationState(String location);
	List<Car> findByModel(String model);
	List<Car> findByBrand(String brand);
	List<Car> findByCustomerNotNull();

}
