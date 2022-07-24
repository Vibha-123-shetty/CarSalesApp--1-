package com.car.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.models.Car;
import com.car.exception.CarNotFoundException;
import com.car.exception.NoCarsException;
import com.car.service.ICarServiceImp;

@RestController
@RequestMapping("CSA/")
public class CarController {
	
	@Autowired
	ICarServiceImp carservice;
	
	@PostMapping(path= "car/add")
	public ResponseEntity<Car> addNewCar(@RequestBody Car car)
	{
		if(car == null)
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(carservice.addCar(car), HttpStatus.OK);
		
	}
	@DeleteMapping(path= "car/del/{carId}")
	public String deleteCarById(@PathVariable("carId") Long id)
	{
		if(carservice.removeCar(id) == null)
		{
			throw new CarNotFoundException();
		}
		return "Deleted successfully";
	}
	
	@PutMapping(path="car/update/{carId}")
	public ResponseEntity<Car> updateCarById(@PathVariable("carId") Long id, @RequestBody Car car)
	{
		if(carservice.updateCar(id, car) == null)
		{
			throw new CarNotFoundException();
		}
		return new ResponseEntity<>(carservice.updateCar(id, car), HttpStatus.OK);
	}
	
	@GetMapping(path="car/getbyid/{carId}")
	public ResponseEntity<Car> getCarById(@PathVariable("carId") Long id)
	{
		if(carservice.getCar(id) == null)
		{
			throw new CarNotFoundException();
		}
		return new ResponseEntity<>(carservice.getCar(id), HttpStatus.OK);
	}
	
	
	@GetMapping(path="/allcars")
	public ResponseEntity<List<Car>> getAllCars()
	{
		if(carservice.getAllCars().isEmpty())
		{
			throw new NoCarsException();
		}
		return new ResponseEntity<>(carservice.getAllCars(), HttpStatus.OK);	
	}
	
	@GetMapping(path="car/getbyloc/{registrationState}")
	public ResponseEntity<List<Car>> getCarsByLocation(@PathVariable("registrationState") String location)
	{
		if(carservice.getCarsByLocation(location).isEmpty())
		{
			throw new CarNotFoundException();
		}
		return new ResponseEntity<>(carservice.getCarsByLocation(location), HttpStatus.OK);
		
	}
	
	@GetMapping(path="car/getbymod/{model}")
	public ResponseEntity<List<Car>> getCarsByModel(@PathVariable("model") String model)
	{
		if(carservice.getCarsByModel(model).isEmpty())
		{
			throw new CarNotFoundException();
		}
		return new ResponseEntity<>(carservice.getCarsByModel(model), HttpStatus.OK);
		
	}
	
	@GetMapping(path="car/getbybrad/{brand}")
	public ResponseEntity<List<Car>> getCarsByBrand(@PathVariable("brand") String brand)
	{
		if(carservice.getCarsByBrand(brand).isEmpty())
		{
			throw new CarNotFoundException();
		}
		return new ResponseEntity<>(carservice.getCarsByBrand(brand), HttpStatus.OK);

		
	}
	
	

}