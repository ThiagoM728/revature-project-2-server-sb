package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job_Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 20, name = "job_id")
	private int jobId;

	@Column(length = 20, name = "student_id")
	private int studentId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + jobId;
		result = prime * result + studentId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job_Student other = (Job_Student) obj;
		if (id != other.id)
			return false;
		if (jobId != other.jobId)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Job_Student [id=" + id + ", jobId=" + jobId + ", studentId=" + studentId + "]";
	}

	public Job_Student(int id, int jobId, int studentId) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.studentId = studentId;
	}

	public Job_Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}