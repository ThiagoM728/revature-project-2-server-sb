package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// private int companyId;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "business_id")
	@JsonBackReference
//	@JsonManagedReference
	private Business business;

	@Column(length = 50)
	private int business_id_fk;

	@Column(length = 30)
	private String name;

	@Column(length = 20)
	private String major;

	@Column(length = 20) // format = "City, State"
	private String location;

	@Column(length = 20)
	private String department;

	@Column(length = 10)
	private String type; // TODO: maybe change to foreign key pointing to a table that holds the types?

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public int getBusiness_id_fk() {
		return business_id_fk;
	}

	public void setBusiness_id_fk(int business_id_fk) {
		this.business_id_fk = business_id_fk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((business == null) ? 0 : business.hashCode());
		result = prime * result + business_id_fk;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Job other = (Job) obj;
		if (business == null) {
			if (other.business != null)
				return false;
		} else if (!business.equals(other.business))
			return false;
		if (business_id_fk != other.business_id_fk)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", business=" + business + ", business_id_fk=" + business_id_fk + ", name=" + name
				+ ", major=" + major + ", location=" + location + ", department=" + department + ", type=" + type + "]";
	}

	public Job(int id, Business business, int business_id_fk, String name, String major, String location,
			String department, String type) {
		super();
		this.id = id;
		this.business = business;
		this.business_id_fk = business_id_fk;
		this.name = name;
		this.major = major;
		this.location = location;
		this.department = department;
		this.type = type;
	}

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

}
