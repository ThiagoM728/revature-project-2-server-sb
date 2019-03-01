package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Student;
import com.revature.repositories.StudentRepository;

@Service
public class StudentService {
	StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	public Student createStudent(Student student) {
		// Internal business logic: validation, etc
		return studentRepository.createStudent(student);
	}
}
