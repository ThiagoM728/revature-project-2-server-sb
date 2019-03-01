package com.revature.repositories;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
}
