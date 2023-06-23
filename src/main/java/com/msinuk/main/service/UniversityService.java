package com.msinuk.main.service;

import java.util.*;

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
		Map<String,String[]> courses = new HashMap<String,String[]>();
		courses.put("Accounting and Finance",new String[] {"Accounting and Finance PhD","Accounting and Financial Management MSc","Finance MSc","Financial Analysis (Advanced) MSc"});
		courses.put("Architecture",new String[] {"Architecture PhD","Architecture (Master of) MArch"});
		courses.put("Art",new String[] {"Art PhD","Arts Management MA","Contemporary Arts PhD","Fine Art MA"});
		courses.put("Biological Sciences",new String[] {"Biological Science PhD","Food Challenges for the 21st Century (Distance Learning) PgCert","Food Security (Distance Learning) MSc","Food Security (Distance Learning) PgDip"
				+ "","Plant Sciences MSc by Research"});
		courses.put("Engineering",new String[] {"Electronic Engineering MSc","Mechanical Engineering (Advanced) MSc","Mechanical Engineering with Project Management MSc","Natural Sciences MSc by Research"});
		courses.put("Medicine",new String[] {"Anaesthesia and Peri-Operative Sciences PgDip","Clinical Research MSc","Medicine PhD","Medicine M.D."});
		String[] departments = {"Accounting and Finance","Architecture","Art","Biological Sciences","Engineering","Medicine"};
		String description= "Lancaster University campus occupies a beautiful 560-acre parkland site and is proud to be one of only a handful of UK universities with a collegiate system.";
		String[] images = {"lanchaster.jpg","lanchaster1.jpg","lanchaster2.jpg","lanchaster3.jpg"};
		UniversityDetails undetails = new UniversityDetails(1, "Lancaster University", "University House, Bailrigg, Lancaster LA1 4YW,UK", courses, 4.1, departments, description, images, "General Enquiries: +44 (0)1524 65201.");
		
		this.universityRepo.save(undetails);
		return this.universityRepo.findByUniversityName(universityName);
		
	}

	
}
