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
import com.revature.services.BusinessService;
import com.revature.services.StudentService;

@CrossOrigin(allowedHeaders="content-type", methods= {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/login")
public class LoginController {
	BusinessService businessService;
	StudentService studentService;
	
	@Autowired
	public LoginController(BusinessService businessService) {
		super();
		this.businessService = businessService;
	}
	
	@PostMapping("/business")
	//@ResponseBody
	public Business businessLogin(@RequestBody LoginDTO dto) throws IOException {
		return this.businessService.login(dto);
	}
	
//	@PostMapping("/student")
//	//@ResponseBody
//	public Student studentLogin(@RequestBody LoginDTO dto) throws IOException{
//		return this.businessService.login(dto);
//	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleHttpClientException(HttpClientErrorException e) {
		String message = e.getMessage();
		return ResponseEntity
				.status(e.getStatusCode())
				.body(message);
	}
	
}
