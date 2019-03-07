package com.revature.repositories;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Business;
import com.revature.models.Business_Event;
import com.revature.models.Event;

@Repository
public class EventRepository {
	@Autowired
	EntityManagerFactory emf;
	@Autowired
	BusinessRepository br;

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

	public List<Business> getBusiness(int id) {
		// TODO Auto-generated method stub
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Business_Event> criteria = cb.createQuery(Business_Event.class);
			Root<Business_Event> root = criteria.from(Business_Event.class);
			// System.out.println(id);
			criteria.select(root).where(cb.equal(root.get("eventId"), id));
			Query<Business_Event> query = session.createQuery(criteria); 
			List<Business_Event> temp = query.getResultList();
			List<Business> results = new ArrayList<Business>();
			for(Business_Event i : temp) {
				int business_id = i.getBusinessId();
				try {
					results.add(br.findById(business_id));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return results;

		}
	}

	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Event> criteria = cb.createQuery(Event.class);
			Root<Event> root = criteria.from(Event.class);
			// System.out.println(id);
			criteria.select(root);
			Query<Event> query = session.createQuery(criteria); 
			return query.getResultList();
		}
	}

	public List<Event> getEventsRSVP(int id) {
		// TODO Auto-generated method stub
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Business_Event> criteria = cb.createQuery(Business_Event.class);
			Root<Business_Event> root = criteria.from(Business_Event.class);
			// System.out.println(id);
			criteria.select(root);
			criteria.where(cb.equal(root.get("businessId"), id));
			Query<Business_Event> query = session.createQuery(criteria); 
			List<Business_Event> temp = query.getResultList();
			List<Event> result = new ArrayList<Event>();
			for(Business_Event i : temp) {
				Event event = findEventById(i.getEventId());
				result.add(event);
			}
			return result;
		}
	}

}
