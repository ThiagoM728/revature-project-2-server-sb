package com.revature.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.BusinessSignupDTO;
import com.revature.models.Business;
import com.revature.services.BusinessService;
import com.revature.services.StudentService;

@CrossOrigin(allowedHeaders="content-type", methods= {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/signup")
public class SignupController {
	BusinessService businessService;
	StudentService studentService;
	
	@Autowired
	public SignupController(BusinessService businessService) {
		super();
		this.businessService = businessService;
	}
	
	@PostMapping("/business")
	//@ResponseBody
	public Business businessSignup(@RequestBody BusinessSignupDTO dto) throws IOException {
		return this.businessService.createBusiness(dto);
	}
}
