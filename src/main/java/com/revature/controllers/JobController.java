package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public Job saveJob(@RequestBody Job job) {
		return this.jobService.createJob(job);
	}
}
