package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Business;
import com.revature.repositories.BusinessRepository;

@Service
public class BusinessService {
	BusinessRepository businessRepository;
	
	@Autowired
	public BusinessService(BusinessRepository businessRepository) {
		super();
		this.businessRepository = businessRepository;
	}
	
	public Business createBusiness(Business business) {
		//to-do add validation
		return businessRepository.createBusiness(business);
	}
	
	public Business getBusiness(int id) {
		return businessRepository.findById(id);
	}
	
}
