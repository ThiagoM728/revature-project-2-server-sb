package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Job;
import com.revature.repositories.JobRepository;

@Service
public class JobService {
	JobRepository jobRepository;
	
	@Autowired
	public JobService(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}
	
	public Job createJob(Job job) {
		// Internal business logic: validation, etc
		return jobRepository.createJob(job);
	}
}
