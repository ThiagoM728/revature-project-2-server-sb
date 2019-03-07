package com.revature.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "name", length=30)
	private String name;
	
	@Column(name= "Location", length=30)
	private String Location;
	
	@Column(name= "date", length=30)
	private Date date;
	
	@Column(name= "photo", length=30)
	private Boolean photo;
	
	@Column(name= "map", length=30)
	private Boolean map;
	
	@Column(length=255)
	private String description;
	
	@Column(name="contact_email", length=50)
	private String contactEmail;
	
	@Column(name="contact_name", length=50)
	private String contactName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getPhoto() {
		return photo;
	}

	public void setPhoto(Boolean photo) {
		this.photo = photo;
	}

	public Boolean getMap() {
		return map;
	}

	public void setMap(Boolean map) {
		this.map = map;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Location == null) ? 0 : Location.hashCode());
		result = prime * result + ((contactEmail == null) ? 0 : contactEmail.hashCode());
		result = prime * result + ((contactName == null) ? 0 : contactName.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
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
		Event other = (Event) obj;
		if (Location == null) {
			if (other.Location != null)
				return false;
		} else if (!Location.equals(other.Location))
			return false;
		if (contactEmail == null) {
			if (other.contactEmail != null)
				return false;
		} else if (!contactEmail.equals(other.contactEmail))
			return false;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", Location=" + Location + ", date=" + date + ", photo=" + photo
				+ ", map=" + map + ", description=" + description + ", contactEmail=" + contactEmail + ", contactName="
				+ contactName + "]";
	}

	public Event(int id, String name, String location, Date date, Boolean photo, Boolean map, String description,
			String contactEmail, String contactName) {
		super();
		this.id = id;
		this.name = name;
		Location = location;
		this.date = date;
		this.photo = photo;
		this.map = map;
		this.description = description;
		this.contactEmail = contactEmail;
		this.contactName = contactName;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
