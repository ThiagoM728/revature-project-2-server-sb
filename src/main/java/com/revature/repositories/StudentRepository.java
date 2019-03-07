package com.revature.repositories;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
			js.setActive(true);
			
			if(!isFav(student_id, job_id)) {
				Transaction tx = session.beginTransaction();
				session.persist(js);
				session.flush();
				tx.commit();
			}
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
//			criteria.select(root).where(cb.equal(root.get("active"), true));
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
	
	public boolean isFav(int s_id, int j_id) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Job_Student> criteria = cb.createQuery(Job_Student.class);
			Root<Job_Student> root = criteria.from(Job_Student.class);
			criteria.select(root);
			criteria.where(
					cb.equal(root.get("studentId"), s_id),
					cb.equal(root.get("jobId"), j_id)
					);
			Query<Job_Student> query = session.createQuery(criteria); 
			List<Job_Student> temp = query.getResultList();	
			boolean result = !(temp.isEmpty());
			return result;
		}
	}
	
	public Job_Student getJS(int s_id, int j_id) throws SQLException {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Job_Student> criteria = cb.createQuery(Job_Student.class);
			Root<Job_Student> root = criteria.from(Job_Student.class);
			criteria.select(root).where(cb.equal(root.get("studentId"), s_id));
			criteria.select(root).where(cb.equal(root.get("jobId"), j_id));
			Query<Job_Student> query = session.createQuery(criteria); 
			List<Job_Student> temp = query.getResultList();
			System.out.println("TEST!!!!!");
			System.out.println(temp.get(0));
			return temp.get(0);
		}
	}

	public String deleteFav(int s_id, int j_id) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("delete Job_Student where studentId = :studentId AND jobId = :jobId");
			query.setParameter("studentId", s_id);
			query.setParameter("jobId", j_id);
			//System.out.println(query);
//			 
			int temp = query.executeUpdate();
			tx.commit();
			String result;
			if (temp > 0) {
				result = j_id + " was removed from favorites!";
			    return result;
			}
			result = j_id + " was not in favorites";
			return result;

		}
	}
}
