package com.car.service;
import java.util.List;

import com.car.models.Car;

public interface ICarService {
	public Car addCar(Car car);
	public Car removeCar(long id);
	public Car updateCar(long id, Car car);
	public Car getCar(long id);
	public List<Car> getAllCars();
	public List<Car> getCarsByLocation(String location);
	public List<Car> getCarsByModel(String model);
	public List<Car> getCarsByBrand(String brand);

}