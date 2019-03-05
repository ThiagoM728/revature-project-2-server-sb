package com.revature.dto;

public class JobDTO {
	private int business_id;
	private String name;
	private String major;
	private String location_city;
	private String location_state;
	private String department;
	private String type;
	public int getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(int business_id) {
		this.business_id = business_id;
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
	public String getLocation_city() {
		return location_city;
	}
	public void setLocation_city(String location_city) {
		this.location_city = location_city;
	}
	public String getLocation_state() {
		return location_state;
	}
	public void setLocation_state(String location_state) {
		this.location_state = location_state;
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
		result = prime * result + business_id;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((location_city == null) ? 0 : location_city.hashCode());
		result = prime * result + ((location_state == null) ? 0 : location_state.hashCode());
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
		JobDTO other = (JobDTO) obj;
		if (business_id != other.business_id)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (location_city == null) {
			if (other.location_city != null)
				return false;
		} else if (!location_city.equals(other.location_city))
			return false;
		if (location_state == null) {
			if (other.location_state != null)
				return false;
		} else if (!location_state.equals(other.location_state))
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
		return "JobDTO [business_id=" + business_id + ", name=" + name + ", major=" + major + ", location_city="
				+ location_city + ", location_state=" + location_state + ", department=" + department + ", type=" + type
				+ "]";
	}
	public JobDTO(int business_id, String name, String major, String location_city, String location_state,
			String department, String type) {
		super();
		this.business_id = business_id;
		this.name = name;
		this.major = major;
		this.location_city = location_city;
		this.location_state = location_state;
		this.department = department;
		this.type = type;
	}
	public JobDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
