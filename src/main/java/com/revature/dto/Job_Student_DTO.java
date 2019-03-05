package com.revature.dto;

import com.revature.models.Job;
import com.revature.models.Student;

public class Job_Student_DTO {
	private int jobId;
	private int studentId;

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
		Job_Student_DTO other = (Job_Student_DTO) obj;
		if (jobId != other.jobId)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Job_Student_DTO [jobId=" + jobId + ", studentId=" + studentId + "]";
	}

	public Job_Student_DTO(int jobId, int studentId) {
		super();
		this.jobId = jobId;
		this.studentId = studentId;
	}

	public Job_Student_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
