package com.revature.repositories;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Business;
import com.revature.models.Job;
import com.revature.models.Student;

@Repository
public class JobRepository {
	@Autowired
	EntityManagerFactory emf;

	public Job createJob(Job job) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);

		try (Session session = sf.openSession()) {
			int id = (int) session.save(job);
			job.setId(id);
			// business.addJob(job);
			// session.merge(business);
			return job;
		}
	}

	public Job getJobById(int id) throws SQLException {
		SessionFactory sf = emf.unwrap(SessionFactory.class);

		try (Session session = sf.openSession()) {
			return session.get(Job.class, id);

		}
	}
	
}
