package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Event;
import com.revature.services.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	EventService eventService;
	
	@Autowired
	public EventController (EventService eventService) {
		super();
		this.eventService = eventService; 
	}
	@PostMapping("")
	public Event saveEvent(@RequestBody Event event) {
		return this.eventService.createEvent(event);
	}
	
}
