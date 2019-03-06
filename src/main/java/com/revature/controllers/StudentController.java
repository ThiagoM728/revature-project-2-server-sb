package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.Job_Student_DTO;
import com.revature.models.Job;
import com.revature.models.Student;
import com.revature.services.StudentService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "content-type", methods = { RequestMethod.GET, RequestMethod.POST })
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
	public Student saveStudent(@RequestBody @Valid Student student) {
		return this.studentService.createStudent(student);
	}
	
	@PostMapping("/addFav")
	public Job saveJob(@RequestBody Job_Student_DTO dto) {
//		System.out.println(dto);
		return this.studentService.createFav(dto);
	}
	
	@GetMapping("favJobs/{id}")
	public List<Job> getFavJobs(@PathVariable int id) {
		return this.studentService.getFavJobs(id);
	}
	
	@PutMapping("removeFav/studentId={s_id}/jobId={j_id}")
	public Job removeFavJob(@PathVariable int s_id, int j_id) {
		return this.studentService.removeFavJob(s_id, j_id);
	}
}
