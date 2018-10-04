package com.apap.tutorial4.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.repository.CarDb;

/**
 * CarServiceImpl
 */
@Service
@Transactional
public class CarServiceImpl implements CarService{
	@Autowired
	private CarDb carDb;
	
	@Override
	public void addCar(CarModel car) {
		carDb.save(car);
	}

	// delete
	@Override
	public void deleteCar(Long carIdd) {
		carDb.deleteById(carIdd);
		
	}

	// update
	@Override
	public void updateCar(Long carIdu, String carBrandu, String carTypeu, Long carPriceu, Integer carAmountu) {
		carDb.getOne(carIdu).setBrand(carBrandu);
		carDb.getOne(carIdu).setType(carTypeu);
		carDb.getOne(carIdu).setPrice(carPriceu);
		carDb.getOne(carIdu).setAmount(carAmountu);		
	}
}
