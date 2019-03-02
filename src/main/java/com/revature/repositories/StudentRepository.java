package com.revature.repositories;

import java.sql.SQLException;
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

import com.revature.models.Student;

@Repository
public class StudentRepository {
	@Autowired
	EntityManagerFactory emf;
	
	public Student createStudent(Student student) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		
		try(Session session = sf.openSession()) {
			int id = (int) session.save(student);
			student.setId(id);
			return student;
		}
	}

	public Student findById(int id) throws SQLException {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		
		try(Session session = sf.openSession()) {
			return session.get(Student.class, id);
		}
		
	}
	
	public Student findByEmail (String email) throws SQLException {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		
		try (Session session = sf.openSession()) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Student> criteria = cb.createQuery(Student.class);
			Root<Student> root = criteria.from(Student.class);
			criteria.select(root).where(cb.equal(root.get("email"), email));
			Query<Student> query = session.createQuery(criteria); 
			List<Student> results = query.getResultList();
			
			if(results.isEmpty() || results.size() > 1) {
				return null;
			} else {
				Student student = results.get(0);
				return student; 
			}
			
		}
	}
	
	
}
