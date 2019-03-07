package com.revature.controllers;

import java.sql.SQLException;
import java.util.List;

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

import com.revature.dto.JobDTO;
import com.revature.models.Business;
import com.revature.models.Job;
import com.revature.services.JobService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "content-type", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@RestController
@RequestMapping("/jobs")
public class JobController {
	JobService jobService;
	
	@Autowired
	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@PostMapping("")
	public Job saveJob(@RequestBody JobDTO dto) throws SQLException {
		return this.jobService.createJob(dto);
	}
	
	@GetMapping("")
	public List<Job> getAllJobs() {
		return this.jobService.getAllJobs();
	}
	
	@GetMapping("/{id}")
	public Job getJob(@PathVariable int id) {
		return this.jobService.getJob(id);
	}
	
	@GetMapping("getCompany/jobId={id}")
	public Business getBusiness(@PathVariable int id) {
		System.out.println(id);
		return this.jobService.getBusiness(id);
	}
	
	@PutMapping("/updateActive/{id}")
	public Job updateActiveJob(@PathVariable int id) {
		//System.out.println(id);
		return this.jobService.updateActiveJob(id);
	}
	
}
