package com.apap.tutorial4.service;

import com.apap.tutorial4.model.CarModel;

/**
 * CarService
 */
public interface CarService {
	void addCar(CarModel car);
	// delete
	void deleteCar(Long carIdd);
	//update
	void updateCar(Long carIdu, String carBrandu, String carTypeu, Long carPriceu, Integer carAmountu);	
}
