package com.revature.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(length = 100, name = "business_name")
	private String businessName;

	@Column(length = 30)
	private String name;

	@Column(length = 20)
	private String major;

	@Column(length = 20, name = "location_city") // format = "City, State"
	private String locationCity;

	@Column(length = 20, name = "location_state") // format = "City, State"
	private String locationState;

	@Column(length = 20)
	private String department;
	
	@Column(length = 255)
	private String description;

	@Column(length = 10)
	private String type; // TODO: maybe change to foreign key pointing to a table that holds the types?

	@Column(length = 10)
	private boolean active;

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

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
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

	public String getLocationCity() {
		return locationCity;
	}

	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}

	public String getLocationState() {
		return locationState;
	}

	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		result = prime * result + ((business == null) ? 0 : business.hashCode());
		result = prime * result + ((businessName == null) ? 0 : businessName.hashCode());
		result = prime * result + business_id_fk;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((locationCity == null) ? 0 : locationCity.hashCode());
		result = prime * result + ((locationState == null) ? 0 : locationState.hashCode());
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
		if (active != other.active)
			return false;
		if (business == null) {
			if (other.business != null)
				return false;
		} else if (!business.equals(other.business))
			return false;
		if (businessName == null) {
			if (other.businessName != null)
				return false;
		} else if (!businessName.equals(other.businessName))
			return false;
		if (business_id_fk != other.business_id_fk)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (locationCity == null) {
			if (other.locationCity != null)
				return false;
		} else if (!locationCity.equals(other.locationCity))
			return false;
		if (locationState == null) {
			if (other.locationState != null)
				return false;
		} else if (!locationState.equals(other.locationState))
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
		return "Job [id=" + id + ", business=" + business + ", business_id_fk=" + business_id_fk + ", businessName="
				+ businessName + ", name=" + name + ", major=" + major + ", locationCity=" + locationCity
				+ ", locationState=" + locationState + ", department=" + department + ", description=" + description
				+ ", type=" + type + ", active=" + active + "]";
	}

	public Job(int id, Business business, int business_id_fk, String businessName, String name, String major,
			String locationCity, String locationState, String department, String description, String type,
			boolean active) {
		super();
		this.id = id;
		this.business = business;
		this.business_id_fk = business_id_fk;
		this.businessName = businessName;
		this.name = name;
		this.major = major;
		this.locationCity = locationCity;
		this.locationState = locationState;
		this.department = department;
		this.description = description;
		this.type = type;
		this.active = active;
	}

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
