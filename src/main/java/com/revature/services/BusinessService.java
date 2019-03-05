package com.revature.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.dto.BusinessSignupDTO;
import com.revature.dto.LoginDTO;
import com.revature.models.Business;
import com.revature.models.Job;
import com.revature.repositories.BusinessRepository;
import com.revature.repositories.JobRepository;

@Service
public class BusinessService {
	BusinessRepository businessRepository;
	JobRepository jobRepository;

	@Autowired
	public BusinessService(BusinessRepository businessRepository, JobRepository jobRepository) {
		super();
		this.businessRepository = businessRepository;
		this.jobRepository = jobRepository;
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
		// int id = dto.getId();
		String username = dto.getUsername();

		try {
			business = businessRepository.findByUsername(username);
			// System.out.println(business);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String passhash = BCrypt.hashpw(dto.getPassword(), business.getSalt());

		if (business != null && business.getHash().equals(passhash)) {
			// System.out.println("login successful");
			return business;
		}
		throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "No business found with this username");
	}

	public List<Job> getJobs(int id) {
		try {
			Business business = businessRepository.findById(id);
			if(business != null) {
				return businessRepository.getJobsById(id);
			} else {
				throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Business doesn't exist");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		//TODO: fix error handling, currently displays nothing
	}
}
