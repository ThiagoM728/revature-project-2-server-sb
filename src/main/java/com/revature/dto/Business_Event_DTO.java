package com.revature.dto;

public class Business_Event_DTO {
	private int businessId;
	private int eventId;

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
		Business_Event_DTO other = (Business_Event_DTO) obj;
		if (businessId != other.businessId)
			return false;
		if (eventId != other.eventId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Business_Event_DTO [businessId=" + businessId + ", eventId=" + eventId + "]";
	}

	public Business_Event_DTO(int businessId, int eventId) {
		super();
		this.businessId = businessId;
		this.eventId = eventId;
	}

	public Business_Event_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
