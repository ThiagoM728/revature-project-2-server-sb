package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.dto.Job_Student_DTO;
import com.revature.dto.LoginDTO;
import com.revature.dto.StudentSignupDTO;
import com.revature.models.Job;
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
//		System.out.println(dto);
		Student student = new Student();
		
		String email = dto.getEmail();
		
		try {
			student = studentRepository.findByEmail(email); 
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		String passhash = BCrypt.hashpw(dto.getPassword(), student.getSalt());
//		System.out.println(student);
//		System.out.println(student.getHash().equals(passhash));
		
		if(student != null && student.getHash().equals(passhash)) {
			return student;
		}
		
		throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "No business found with this email ");
	}

	public Job createFav(Job_Student_DTO dto) {
		// TODO Auto-generated method stub
		int job_id = dto.getJobId();
		int student_id = dto.getStudentId();
		System.out.println(job_id);
		System.out.println(student_id);
		return studentRepository.addFav(job_id, student_id);
	}

	public List<Job> getFavJobs(int id) {
		return studentRepository.getFavJobs(id);
	}
}
