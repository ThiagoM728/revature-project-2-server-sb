package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dto.JobDTO;
import com.revature.models.Business;
import com.revature.models.Job;
import com.revature.repositories.BusinessRepository;
import com.revature.repositories.JobRepository;

@Service
public class JobService {
	JobRepository jobRepository;
	BusinessRepository b_repo;
	@Autowired
	public JobService(JobRepository jobRepository, BusinessRepository b_repo) {
		super();
		this.jobRepository = jobRepository;
		this.b_repo = b_repo;
	}
	
	public Job createJob(JobDTO dto) {
		int business_id = dto.getBusiness_id();
		System.out.println(business_id);
		Business business = new Business();
		try {
			business = b_repo.findById(business_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(business);
		Job job = new Job();
		//job.setBusinessId(dto.getBusiness_id());
		job.setBusiness(business);
		job.setBusiness_id_fk(business_id);
		job.setBusinessName(business.getCompanyName());
//		job.setBusiness_id(business_id);
		job.setName(dto.getName());
		job.setMajor(dto.getMajor());
		job.setLocationCity(dto.getLocation_city());
		job.setLocationState(dto.getLocation_state());
		job.setDepartment(dto.getDepartment());
		job.setDescription(dto.getDescription());
		job.setActive(true);
		job.setType(dto.getType());
		return jobRepository.createJob(job);
	}

	public Job getJob(int id) {
		Job job = new Job();
		// TODO Auto-generated method stub
		try {
			return jobRepository.getJobById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return job;
	}

	public Job updateActiveJob(int id) {
		// TODO Auto-generated method stub
		return jobRepository.updateActiveJob(id);
	}

	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		return jobRepository.getAllJobs();
	}

	public Business getBusiness(int id) {
		// TODO Auto-generated method stub
		Business business = new Business();
		try {
			business = b_repo.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(business);
		return business;
	}

}
