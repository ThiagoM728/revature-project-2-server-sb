package com.revature.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.JobDTO;
import com.revature.models.Job;
import com.revature.services.JobService;

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
	
	@GetMapping("/{id}")
	public Job getJob(@PathVariable int id) {
		return this.jobService.getJob(id);
	}
	
}
