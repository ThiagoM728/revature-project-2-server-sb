package com.revature.services;

import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.dto.BusinessSignupDTO;
import com.revature.dto.LoginDTO;
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
	
//	public Business createBusiness(Business business) {
//		//to-do add validation
//		return businessRepository.createBusiness(business);
//	}
	
	public Business createBusiness(BusinessSignupDTO dto) {
		Business business = new Business();
		String username = dto.getUsername();
		String companyName = dto.getCompanyName();
		String password = dto.getPassword();
		String salt = BCrypt.gensalt(12);
		String passHash = BCrypt.hashpw(dto.getPassword(), salt);
		String description = dto.getDescription();
		
		business.setUsername(username);
		business.setCompanyName(companyName);
		business.setSalt(salt);
		business.setHash(passHash);
		business.setDescription(description);
		// TODO: add jbcrrpt to pom.xml salt + hash password
		// pass this business object to the business repository
		return businessRepository.createBusiness(business);
	}
	
	public Business getBusiness(int id) {
		Business business = new Business();

		try {
			return businessRepository.findById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return business;
	}
	
	public Business login(LoginDTO dto) {
		Business business = new Business();
		//int id = dto.getId();
		String username = dto.getUsername();
		
		try {
			business = businessRepository.findByUsername(username);
		}catch(SQLException e){
		 e.printStackTrace();
		}
		String passhash = BCrypt.hashpw(dto.getPassword(), business.getSalt());
		
		if(business != null && business.getHash().equals(passhash)) {
			return business;
		}
		throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "No business found with this username");
	}
	
}
