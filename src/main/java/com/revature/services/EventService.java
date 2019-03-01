package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Event;
import com.revature.repositories.EventRepository;

@Service
public class EventService {
	
	EventRepository eventRepository;
	
	@Autowired
	public EventService(EventRepository eventRepository) {
		super(); 
		this.eventRepository = eventRepository; 
	}
	
	public Event createEvent (Event event) {
		return eventRepository.createEvent(event);
	}
}
