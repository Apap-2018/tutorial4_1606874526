package com.apap.tutorial4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.apap.tutorial4.model.*;
import com.apap.tutorial4.service.*;

/**
 * CarController
 */
@Controller
public class CarController {
	@Autowired
	private CarService carService;
	
	@Autowired
	private DealerService dealerService;
	
	@RequestMapping(value = "/car/add/{dealerId}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "dealerId") Long dealerId, Model model) {
	CarModel car = new CarModel();
	DealerModel dealer = dealerService.getDealerDetailById(dealerId).get();
	car.setDealer(dealer);
	
	model.addAttribute("car", car);
	return "addCar";
	}
	
	@RequestMapping(value = "/car/add", method = RequestMethod.POST)
	private String addCarSubmit(@ModelAttribute CarModel car) {
		carService.addCar(car);
		return "add";
	}
	
	// delete
	@RequestMapping(value = "/car/delete", method = RequestMethod.GET)
	private String deleteCarById(@RequestParam("carIdd") Long carIdd, Model model) {
		
		carService.deleteCar(carIdd);
		return "delete";
	}
	
	// update
	@RequestMapping(value = "/car/update", method = RequestMethod.GET)
	private String updateCarById(@RequestParam("carIdu") Long carIdu, Model model, @RequestParam("carBrandu") String carBrandu, @RequestParam("carTypeu") String carTypeu, @RequestParam("carPriceu") Long carPriceu, @RequestParam("carAmountu") Integer carAmountu) {
		carService.updateCar(carIdu, carBrandu, carTypeu, carPriceu, carAmountu);
		return "update";
	}
}
