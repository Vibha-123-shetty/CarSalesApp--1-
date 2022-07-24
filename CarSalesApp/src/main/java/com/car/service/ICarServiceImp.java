package com.car.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.ICarRepository;
import com.car.models.Car;

@Service
public class ICarServiceImp implements ICarService {

	@Autowired
	private ICarRepository carrepo;
	

	@Override
	public Car addCar(Car car) {	
		carrepo.save(car);
		return car;
	}

	@Override
	public Car removeCar(long id) {
		Car car = getCarRec(id);
		Car copy = car;
		if(car != null)
		{
			carrepo.deleteById(id);
		}
		return copy;
	}
	
	@Override
	public Car updateCar(long id, Car car) {
		Car mycar = getCarRec(id);
		if(mycar != null)
		{
			mycar.setBrand(car.getBrand());
			mycar.setModel(car.getModel());
			mycar.setVariant(car.getVariant());
			mycar.setRegistrationState(car.getRegistrationState());
			mycar.setRegistrationYear(car.getRegistrationYear());
			carrepo.save(mycar);
		}
		return mycar;
	}

	@Override
	public Car getCar(long id) {
		Car car = getCarRec(id);
		return car;
	}

	@Override
	public List<Car> getAllCars() {
		
		return (List<Car>) carrepo.findAll();
	}

	@Override
	public List<Car> getCarsByLocation(String location) {
		
		return (List<Car>) carrepo.findByRegistrationState(location);
	}

	@Override
	public List<Car> getCarsByModel(String model) {
		
		return (List<Car>) carrepo.findByModel(model);
	}

	@Override
	public List<Car> getCarsByBrand(String brand) {
	
		return (List<Car>) carrepo.findByBrand(brand);
	}
	
	
	public Car getCarRec(long id) {
        Optional<Car> carObj = carrepo.findById(id);
        if (carObj.isPresent()) {
            return carObj.get();
        }
        return null;
    }

}
