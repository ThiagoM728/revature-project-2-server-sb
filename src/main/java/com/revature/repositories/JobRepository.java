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
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Business;
import com.revature.models.Job;
import com.revature.models.Job_Student;
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

	public Job updateActiveJob(int id) {
		// TODO Auto-generated method stub
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			Job job = new Job();
			try {
				job = getJobById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			job.setActive(false);
//			System.out.println(job);
			Transaction tx = session.beginTransaction();
			session.update(job);
			tx.commit();
			return job;

		}
	}

	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		SessionFactory sf = emf.unwrap(SessionFactory.class);

		try (Session session = sf.openSession()) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Job> criteria = cb.createQuery(Job.class);
			Root<Job> root = criteria.from(Job.class);
			// System.out.println(id);
			criteria.select(root);
			Query<Job> query = session.createQuery(criteria); 
			return query.getResultList();
		}
	}

}
