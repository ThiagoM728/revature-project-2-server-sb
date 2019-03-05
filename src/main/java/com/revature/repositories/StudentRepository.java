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

import com.revature.models.Business_Event;
import com.revature.models.Job;
import com.revature.models.Job_Student;
import com.revature.models.Student;

@Repository
public class StudentRepository {
	@Autowired
	EntityManagerFactory emf;
	@Autowired
	JobRepository jobRepository;

	public Student createStudent(Student student) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);

		try (Session session = sf.openSession()) {
			int id = (int) session.save(student);
			student.setId(id);
			return student;
		}
	}

	public Student findById(int id) throws SQLException {
		SessionFactory sf = emf.unwrap(SessionFactory.class);

		try (Session session = sf.openSession()) {
			return session.get(Student.class, id);
		}

	}

	public Student findByEmail(String email) throws SQLException {
		SessionFactory sf = emf.unwrap(SessionFactory.class);

		try (Session session = sf.openSession()) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Student> criteria = cb.createQuery(Student.class);
			Root<Student> root = criteria.from(Student.class);
			criteria.select(root).where(cb.equal(root.get("email"), email));
			Query<Student> query = session.createQuery(criteria);
			List<Student> results = query.getResultList();

			if (results.isEmpty() || results.size() > 1) {
				return null;
			} else {
				Student student = results.get(0);
				return student;
			}

		}
	}

	public Job addFav(int job_id, int student_id) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);

		try (Session session = sf.openSession()) {
			Job job = new Job();
			try {
				job = jobRepository.getJobById(job_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Job_Student js = new Job_Student();
			js.setJobId(job_id);
			js.setStudentId(student_id);
			
			int id = (int) session.save(js);
			js.setId(id);
//			System.out.println(js);
			return job;
		}
	}

	public List<Job> getFavJobs(int id) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Job_Student> criteria = cb.createQuery(Job_Student.class);
			Root<Job_Student> root = criteria.from(Job_Student.class);
			// System.out.println(id);
			criteria.select(root).where(cb.equal(root.get("studentId"), id));
			Query<Job_Student> query = session.createQuery(criteria); 
			List<Job_Student> temp = query.getResultList();
			List<Job> results = new ArrayList<Job>();
			for(Job_Student i : temp) {
				int job_id = i.getJobId();
//				System.out.println(job_id);
				try {
					results.add(jobRepository.getJobById(job_id));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return results;

		}
	}
}
