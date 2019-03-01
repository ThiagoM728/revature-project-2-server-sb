package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.BusinessSignupDTO;
import com.revature.models.Business;
import com.revature.services.BusinessService;

@CrossOrigin(allowedHeaders="content-type", methods= {RequestMethod.GET, RequestMethod.POST})
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
	public Business saveBusiness(@RequestBody BusinessSignupDTO dto) {
		return this.businessService.createBusiness(dto);
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
