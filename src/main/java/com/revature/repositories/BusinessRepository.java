package com.revature.repositories;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Business;
import com.revature.models.Business_Event;
import com.revature.models.Job;
import com.revature.models.Job_Student;

@Repository
public class BusinessRepository {
	@Autowired
	EntityManagerFactory emf;

	public Business createBusiness(Business business) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);

		try (Session session = sf.openSession()) {
			int id = (int) session.save(business);
			business.setId(id);
			return business;
		}
	}

	public Business findById(int id) throws SQLException {
		SessionFactory sf = emf.unwrap(SessionFactory.class);

		try (Session session = sf.openSession()) {
			return session.get(Business.class, id);
		}
	}

	public Business findByUsername(String username) throws SQLException {
		SessionFactory sf = emf.unwrap(SessionFactory.class);

		try (Session session = sf.openSession()) {
			//TODO: lookup criteria
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Business> criteria = cb.createQuery(Business.class);
			Root<Business> root = criteria.from(Business.class);
			criteria.select(root).where(cb.equal(root.get("username"), username));
			Query<Business> query = session.createQuery(criteria);
			List<Business> results = query.getResultList();
//			Criteria crit = session.createCriteria(Business.class);
//			crit.add(Restrictions.eq("username","username"));
//			List<Business> results = crit.list();

			if (results.isEmpty() || results.size() > 1) {
				return null;
			} else {
				Business business = results.get(0);
				return business;
			}
		}
	}
	
	public List<Job> getJobsById(int id) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try(Session session = sf.openSession()) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Job> criteria = cb.createQuery(Job.class);
			Root<Job> root = criteria.from(Job.class);
			// System.out.println(id);
			criteria.select(root).where(cb.equal(root.get("business_id_fk"), id));
			Query<Job> query = session.createQuery(criteria); 
			List<Job> results = query.getResultList();
			
			if(results.isEmpty()) {
				return null;
			} else {
				return results;
			}
		}	
	}

	public Business rsvpEvent(int business_id, int event_id) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);

		try (Session session = sf.openSession()) {
			Business business = new Business();
			try {
				business = findById(business_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Business_Event be = new Business_Event();
			be.setBusinessId(business_id);
			be.setEventId(event_id);
			be.setActive(true);
			
			int id = (int) session.save(be);
//			be.setId(id);
			return business;
		}
		
	}
}
