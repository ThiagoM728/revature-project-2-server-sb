package com.revature.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.dto.LoginDTO;
import com.revature.models.Business;
import com.revature.models.Student;
import com.revature.services.BusinessService;
import com.revature.services.StudentService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "content-type", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/login")
public class LoginController {
	BusinessService businessService;
	StudentService studentService;
	
	@Autowired
	public LoginController(BusinessService businessService, StudentService studentService) {
		super();
		this.businessService = businessService;
		this.studentService= studentService; 
	}
	
	@PostMapping("/business")
	//@ResponseBody
	public Business businessLogin(@RequestBody LoginDTO dto) throws IOException {
		System.out.println(dto);
		return this.businessService.login(dto);
	}
	
	@PostMapping("/student")
	//@ResponseBody
	public Student studentLogin(@RequestBody LoginDTO dto) throws IOException{
//		System.out.println(dto);
		return this.studentService.login(dto);
	}
	
	
	
}
