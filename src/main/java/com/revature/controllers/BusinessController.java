package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Business;
import com.revature.services.BusinessService;

@RestController
@RequestMapping("/business")
public class BusinessController {
	BusinessService businessService;
	
	@Autowired
	public BusinessController(BusinessService businessService) {
		super();
		this.businessService = businessService;
	}
	
	@PostMapping("")
	//@ResponseBody
	public Business saveBusiness(@RequestBody Business business) {
		return this.businessService.createBusiness(business);
	}
	
	@GetMapping("/{id}")
	public Business getBusiness(@PathVariable int id) {
		return businessService.getBusiness(id);
	}
	
//	@GetMapping("")
//	public Business getBusiness() {
//		return businessService.getBusiness(1);
//	}
	
}
