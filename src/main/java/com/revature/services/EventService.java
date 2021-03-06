package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Business;
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

	public Event findEventById(int id) {
		
		return eventRepository.findEventById(id);
	}

	public Event updateEvent(Event event, int id) {
		 return eventRepository.updateEvent(event, id); 
		 
	}

	public List<Business> getBusiness(int id) {
		// TODO Auto-generated method stub
		return eventRepository.getBusiness(id);
	}

	public List<Event> getAllEvent() {
		// TODO Auto-generated method stub
		return eventRepository.getAllEvents();
	}

	public List<Event> getEventsRSVP(int id) {
		// TODO Auto-generated method stub
		return eventRepository.getEventsRSVP(id);
	}

}
