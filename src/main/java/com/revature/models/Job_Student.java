package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job_Student implements Serializable {
	@Id
	@Column(length = 20, name = "job_id")
	private Integer jobId;

	@Id
	@Column(length = 20, name = "student_id")
	private Integer studentId;

	@Column(length = 10)
	private boolean active;

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
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
		if (active != other.active)
			return false;
		if (jobId != other.jobId)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Job_Student [jobId=" + jobId + ", studentId=" + studentId + ", active=" + active + "]";
	}

	public Job_Student(int jobId, int studentId, boolean active) {
		super();
		this.jobId = jobId;
		this.studentId = studentId;
		this.active = active;
	}

	public Job_Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
