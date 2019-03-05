package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Business_Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 20, name = "business_id")
	private int businessId;

	@Column(length = 20, name = "event_id")
	private int eventId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + businessId;
		result = prime * result + eventId;
		result = prime * result + id;
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
		Business_Event other = (Business_Event) obj;
		if (businessId != other.businessId)
			return false;
		if (eventId != other.eventId)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Business_Event [id=" + id + ", businessId=" + businessId + ", eventId=" + eventId + "]";
	}

	public Business_Event(int id, int businessId, int eventId) {
		super();
		this.id = id;
		this.businessId = businessId;
		this.eventId = eventId;
	}

	public Business_Event() {
		super();
		// TODO Auto-generated constructor stub
	}

}
