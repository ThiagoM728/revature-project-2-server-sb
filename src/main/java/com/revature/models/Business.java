package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Business {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=30)
	private String username;
	
	@Column(name="company_name", length=30)
	private String companyName;
	
	@Column(name="description", length=255)
	private String description;
	
	@Column(name="logo")
	private boolean logo;
	
	@Column
	private boolean companyPhoto;
	
	@Column(length=255)
	private String hash;
	
	@Column(length=255)
	private String salt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isLogo() {
		return logo;
	}

	public void setLogo(boolean logo) {
		this.logo = logo;
	}

	public boolean isCompanyPhoto() {
		return companyPhoto;
	}

	public void setCompanyPhoto(boolean companyPhoto) {
		this.companyPhoto = companyPhoto;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + (companyPhoto ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		result = prime * result + id;
		result = prime * result + (logo ? 1231 : 1237);
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Business other = (Business) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (companyPhoto != other.companyPhoto)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		if (id != other.id)
			return false;
		if (logo != other.logo)
			return false;
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Business [id=" + id + ", username=" + username + ", companyName=" + companyName + ", description="
				+ description + ", logo=" + logo + ", companyPhoto=" + companyPhoto + ", hash=" + hash + ", salt="
				+ salt + "]";
	}

	public Business(int id, String username, String companyName, String description, boolean logo, boolean companyPhoto,
			String hash, String salt) {
		super();
		this.id = id;
		this.username = username;
		this.companyName = companyName;
		this.description = description;
		this.logo = logo;
		this.companyPhoto = companyPhoto;
		this.hash = hash;
		this.salt = salt;
	}

	public Business() {
		super();
	}

}
