package com.apap.tutorial4.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.service.CarService;
import com.apap.tutorial4.service.DealerService;

/**
 * DealerController
 */
@Controller
public class DealerController {
	@Autowired
	private DealerService dealerService;
	
	@Autowired
	private CarService carService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/dealer/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("dealer", new DealerModel());
		return "addDealer";
	}
	
	@RequestMapping(value = "/dealer/add", method = RequestMethod.POST)
	private String addDealerSubmit(@ModelAttribute DealerModel dealer) {
		dealerService.addDealer(dealer);
		return "add";
	}
	
	
	@RequestMapping(value = "/dealer/view")
	public String viewById(@RequestParam("dealerId") Long dealerId, Model model) {
		DealerModel dealer = dealerService.getDealerDetailById(dealerId).get();
		List<CarModel> listCar = dealer.getListCar();
		model.addAttribute("dealer", dealer);
		model.addAttribute("listCar", listCar);
		return "view-dealer";
	}
	
	// delete
	@RequestMapping(value = "/dealer/delete", method = RequestMethod.GET)
	private String deleteDealerById(@RequestParam("dealerIdd") Long dealerIdd, Model model) {
		dealerService.deleteDealer(dealerIdd);
		return "delete";
	}
	
	// updateDealer(Long dealerIdu, String alamat, String noTelp)
	@RequestMapping(value = "/dealer/update", method = RequestMethod.GET)
	private String updateDealerById(@RequestParam("dealerIdu") Long dealerIdu, Model model, @RequestParam("dealerAlamatu") String dealerAlamatu, @RequestParam("dealerNoTelpu") String dealerNoTelpu) {
		dealerService.updateDealer(dealerIdu, dealerAlamatu, dealerNoTelpu);
		return "update";
	}
	
	// view all dealer
	@RequestMapping(value = "/dealer/view-all", method = RequestMethod.GET)
	public String viewAllDealer(Model model) {
		List<DealerModel> listAllDealer = dealerService.viewAllDealer();
		model.addAttribute("listAllDealer", listAllDealer);
		return "view-all-dealer";
	}
}
