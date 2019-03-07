package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Business_Event implements Serializable {
	@Id
	@Column(length = 20, name = "business_id")
	private int businessId;

	@Id
	@Column(length = 20, name = "event_id")
	private int eventId;
	
	@Column(length = 10)
	private boolean active;

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
		result = prime * result + businessId;
		result = prime * result + eventId;
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
		if (active != other.active)
			return false;
		if (businessId != other.businessId)
			return false;
		if (eventId != other.eventId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Business_Event [businessId=" + businessId + ", eventId=" + eventId + ", active=" + active + "]";
	}

	public Business_Event(int businessId, int eventId, boolean active) {
		super();
		this.businessId = businessId;
		this.eventId = eventId;
		this.active = active;
	}

	public Business_Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
