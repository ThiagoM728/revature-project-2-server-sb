package com.revature.repositories;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Job;

@Repository
public class JobRepository {
	@Autowired
	EntityManagerFactory emf;
	
	public Job createJob(Job job) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		
		try(Session session = sf.openSession()) {
			int id = (int) session.save(job);
			job.setId(id);
			return job;
		}
	}
}
