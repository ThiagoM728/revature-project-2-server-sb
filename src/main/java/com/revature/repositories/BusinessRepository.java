package com.revature.repositories;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Business;

@Repository
public class BusinessRepository {
	@Autowired
	EntityManagerFactory emf;

	public Business createBusiness(Business business) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
				
		try(Session session = sf.openSession()) {
			int id = (int) session.save(business);
			business.setId(id);
			return business;
		}
	}
	

	
	public Business findById(int id) throws ClassNotFoundException{
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		
		try(Session session = sf.openSession()){
			return session.get(Business.class, id);
		}
		
		
	}
}
