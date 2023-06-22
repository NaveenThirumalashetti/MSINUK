package com.msinuk.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msinuk.main.model.University;
import com.msinuk.main.model.UniversityDetails;
import com.msinuk.main.repository.UniversityDetailsRepo;
import com.msinuk.main.repository.UniversityRepo;

@Service
public class UniversityService {
	
	@Autowired
	private UniversityRepo repo;
	@Autowired
	private UniversityDetailsRepo universityRepo;

	public List<University> getUniversities() {
		
		return this.repo.findAll();
	}

	public List<University> getUniversitiesByName(String universityName) {
		// TODO Auto-generated method stub
		return this.repo.findByUniversityName(universityName);
	}
	
	public UniversityDetails getUniversityByName(String universityName) {
		return this.universityRepo.findByUniversityName(universityName);
		
	}

	
}
