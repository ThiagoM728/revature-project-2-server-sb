package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.dto.BusinessSignupDTO;
import com.revature.dto.Business_Event_DTO;
import com.revature.models.Business;
import com.revature.models.Job;
import com.revature.services.BusinessService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "content-type", methods = { RequestMethod.GET, RequestMethod.POST })
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
	// @ResponseBody
	public Business saveBusiness(@RequestBody BusinessSignupDTO dto) {
		return this.businessService.createBusiness(dto);
	}
	
	@PostMapping("/rsvpEvent")
	public Business rsvpEvent(@RequestBody Business_Event_DTO dto) {
		return this.businessService.rsvpEvent(dto);
	}

	@GetMapping("/{id}")
	public Business getBusiness(@PathVariable int id) {
		return businessService.getBusiness(id);
	}
	
	@GetMapping("/job/{id}")
	public List<Job> getJobs(@PathVariable int id) {
		return businessService.getJobs(id);
	}

//	@GetMapping("")
//	public Business getBusiness() {
//		return businessService.getBusiness(1);
//	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleHttpClientException(HttpClientErrorException e) {
		String message = e.getMessage();
		return ResponseEntity
				.status(e.getStatusCode())
				.body(message);
	}

}
