package com.revature.repositories;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Event;

@Repository
public class EventRepository {
	@Autowired
	EntityManagerFactory emf;

	public Event createEvent(Event event) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);

		try (Session session = sf.openSession()) {
			int id = (int) session.save(event);
			event.setId(id);
			return event;
		}
	}

	public Event findEventById(int id) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			return session.get(Event.class, id);
		}

	}

	public Event updateEvent(Event event, int id) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			event.setId(id);
			
			Transaction tx = session.beginTransaction();
			  session.update(event);
			  tx.commit();
			return event;

		}

	}

}
