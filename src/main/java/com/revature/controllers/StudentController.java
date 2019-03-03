package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Student;
import com.revature.services.StudentService;

@CrossOrigin(allowedHeaders="content-type", methods= {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/students")
public class StudentController {
	StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@PostMapping("")
//	@ResponseBody
	public Student saveStudent(@RequestBody Student student) {
		return this.studentService.createStudent(student);
	}
}
