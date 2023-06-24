package com.msinuk.main.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msinuk.main.model.UniversityDetails;
import com.msinuk.main.repository.UniversityDetailsRepo;

@Service
public class UniversityService {


	@Autowired
	private UniversityDetailsRepo universityRepo;

	public List<UniversityDetails> getUniversities() {
		
		return this.universityRepo.findAll();
	}

	public List<UniversityDetails> getUniversitiesByName(String universityName) {
		// TODO Auto-generated method stub
		return this.universityRepo.findByUniversityName(universityName);
	}
	
	public Optional<UniversityDetails> getUniversityById(String unId) {
		return this.universityRepo.findById(Long.parseLong(unId));
		
	}

	
}
