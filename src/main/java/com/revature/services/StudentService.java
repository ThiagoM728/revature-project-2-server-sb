package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.dto.LoginDTO;
import com.revature.dto.StudentSignupDTO;
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
	
	public Student createStudent(StudentSignupDTO dto) {
		Student student = new Student();
		String firstName = dto.getFirstName();
		String lastName = dto.getLastName();
		String email= dto.getEmail();
		
		String salt = BCrypt.gensalt(12);
		String passHash = BCrypt.hashpw(dto.getPassword(), salt);
		
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setSalt(salt);
		student.setHash(passHash);
		
		 return studentRepository.createStudent(student); 
		}

	
	public Student getStudent(int id) {
		Student student = new Student();
		
		try {
			return studentRepository.findById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}
	
	public Student login(LoginDTO dto) {
		Student student = new Student();
		
		String email = dto.getEmail();
		
		try {
			student = studentRepository.findByEmail(email); 
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		String passhash = BCrypt.hashpw(dto.getPassword(), student.getSalt());
		
		if(student != null && student.getHash().equals(passhash)) {
			return student;
		}
		
		throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "No business found with this email ");
	}
}
