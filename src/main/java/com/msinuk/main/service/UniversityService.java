package com.msinuk.main.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.msinuk.main.model.UniversityDetails;
import com.msinuk.main.repository.UniversityDetailsRepo;

@Service
public class UniversityService {


	@Autowired
	private UniversityDetailsRepo universityRepo;

	public List<UniversityDetails> getUniversities() {
		return this.universityRepo.findAll();
	}
	public List<UniversityDetails> addUniversities() throws JsonMappingException, JsonProcessingException {
	
		String jSon ="{\r\n"
				+ "  \"Accounting and Finance\": [\r\n"
				+ "    \"Actuarial Management MSc\",\r\n"
				+ "    \"Actuarial Science MSc\",\r\n"
				+ "    \"Corporate Finance MSc\",\r\n"
				+ "    \"Finance MSc\",\r\n"
				+ "    \"Financial Economics MSc\",\r\n"
				+ "    \"Financial Mathematics MSc\",\r\n"
				+ "    \"Shipping, Trade and Finance MSc\"\r\n"
				+ "  ],\r\n"
				+ "  \"Arts\": [\r\n"
				+ "    \"Composition MA\"\r\n"
				+ "  ],\r\n"
				+ "  \"Business Administration\": [\r\n"
				+ "    \"Insurance and Risk Management MSc; MA; MInnov\",\r\n"
				+ "    \"Modular Executive MBA Programme in London\"\r\n"
				+ "  ],\r\n"
				+ "  \"Business and Management\": [\r\n"
				+ "    \"Banking and International Finance MSc\",\r\n"
				+ "    \"Business Analytics MSc\",\r\n"
				+ "    \"Charity Accounting and Financial Management MSc\",\r\n"
				+ "    \"Charity Marketing and Fundraising MSc\",\r\n"
				+ "    \"Digital Supply Chain Management MSc\",\r\n"
				+ "    \"Entrepreneurship MSc\",\r\n"
				+ "    \"Executive MBA\",\r\n"
				+ "    \"Executive MBA in Dubai\",\r\n"
				+ "    \"Insurance and Risk Management MSc\",\r\n"
				+ "    \"Management MSc\"\r\n"
				+ "  ],\r\n"
				+ "  \"Computing and Information Systems\": [\r\n"
				+ "    \"Computer Games Technology MSc\",\r\n"
				+ "    \"Information Systems and Technology MSc\",\r\n"
				+ "    \"Internet of Things with Entrepreneurship MSc\",\r\n"
				+ "    \"Software Engineering MSc\"\r\n"
				+ "  ],\r\n"
				+ "  \"Economics\": [\r\n"
				+ "    \"Behavioural Economics MSc\",\r\n"
				+ "    \"Business Economics/International Business Economics MSc\",\r\n"
				+ "    \"Development Economics MSc\",\r\n"
				+ "    \"Economics MSc\"\r\n"
				+ "  ],\r\n"
				+ "  \"Education and Teaching\": [\r\n"
				+ "    \"Academic Practice MA\"\r\n"
				+ "  ],\r\n"
				+ "  \"Engineering\": [\r\n"
				+ "    \"Aerospace Engineering MEng (Hons)\"\r\n"
				+ "  ],\r\n"
				+ "  \"English Language and Literature\": [\r\n"
				+ "    \"Creative Writing MFA\"\r\n"
				+ "  ],\r\n"
				+ "  \"Global Media and Digital Cultures\": [\r\n"
				+ "    \"Media and Communications MA\"\r\n"
				+ "  ],\r\n"
				+ "  \"Health\": [\r\n"
				+ "    \"Adult Nursing (pre-registration) MSc\",\r\n"
				+ "    \"Advanced Clinical Practice MSc\",\r\n"
				+ "    \"Children's Nursing (pre-registration) MSc\",\r\n"
				+ "    \"Leading Integrated Care MSc\",\r\n"
				+ "    \"Adult and Mental Health Nursing (pre-registration) MSc\",\r\n"
				+ "    \"Adult Mental Health (Contemporary Studies) MSc\",\r\n"
				+ "    \"Clinical Optometry MSc\",\r\n"
				+ "    \"Medical Ultrasound MSc/Postgrad Diploma/Postgrad Certificate\",\r\n"
				+ "    \"Professional Practice MSc / Postgrad Certificate\",\r\n"
				+ "    \"Public Health MPH\",\r\n"
				+ "    \"Speech and Language Therapy MSc\"\r\n"
				+ "  ],\r\n"
				+ "  \"Humanities\": [\r\n"
				+ "    \"Broadcast Journalism MA\",\r\n"
				+ "    \"Financial Journalism MA\",\r\n"
				+ "    \"Interactive Journalism MA\"\r\n"
				+ "  ],\r\n"
				+ "  \"Law\": [\r\n"
				+ "    \"International Business Law (distance learning) LLM\",\r\n"
				+ "    \"Civil Litigation and Dispute Resolution LLM\",\r\n"
				+ "    \"Criminal Litigation LLM\",\r\n"
				+ "    \"International Banking and Finance Law LLM\",\r\n"
				+ "    \"International Commercial Law LLM\",\r\n"
				+ "    \"International Human Rights LLM\",\r\n"
				+ "    \"Law (Graduate Entry) LLB\",\r\n"
				+ "    \"Legal Practice Course LLM/PGDip/PGCert\",\r\n"
				+ "    \"Legal Practice LLM\"\r\n"
				+ "  ],\r\n"
				+ "  \"Mathematics and Statistics\": [\r\n"
				+ "    \"Mathematics with Data Science MSci (Hons)\"\r\n"
				+ "  ],\r\n"
				+ "  \"Science and Technology\": [\r\n"
				+ "    \"Information Science MSc\",\r\n"
				+ "    \"Maritime Operations and Management in Greece MSc\",\r\n"
				+ "    \"Air Safety Management MSc\",\r\n"
				+ "    \"Air Transport Management MSc\",\r\n"
				+ "    \"Aircraft Maintenance Management MSc\",\r\n"
				+ "    \"Airport Management MSc\",\r\n"
				+ "    \"Civil Engineering Structures MSc\",\r\n"
				+ "    \"Construction Management MSc\"\r\n"
				+ "  ],\r\n"
				+ "  \"Social Sciences\": [\r\n"
				+ "    \"Research Methods MSc\",\r\n"
				+ "    \"Audiovisual Translation and Popular Culture MA\",\r\n"
				+ "    \"Clinical, Social and Cognitive Neuroscience MSc\",\r\n"
				+ "    \"Counselling Psychology (Graduate Certificate)\",\r\n"
				+ "    \"Creative Writing and Publishing MA\",\r\n"
				+ "    \"Creative Writing (Non-Fiction) MA\",\r\n"
				+ "    \"Creative Writing (Novels) MA\",\r\n"
				+ "    \"Creative Writing (Playwriting and Screenwriting) MA\",\r\n"
				+ "    \"Culture, Policy and Management MA\"\r\n"
				+ "  ]\r\n"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
	    @SuppressWarnings("unchecked")
	    Map <String, String[]> courses = mapper.readValue(jSon, new TypeReference<Map<String,String[]>>(){});
		
		String[] departments = {"Accounting and Finance","Arts","Business Administration","Business and Management","Computing and Information Systems","Economics","Education and Teaching","Engineering","English Language and Literature","Global Media and Digital Cultures","Health","Humanities","Law","Mathematics and Statistics","Science and Technology","Social Sciences"};
		String description= "We are a federal University, consisting of 17 independent Member Institutions. As a world leader in higher education, the University has pioneered change since 1836."
				+ "	Our passion for increasing access to education and mobilising the collective power and expertise of the federation is central to our ability to transform lives around the world and address the global challenges of the future.";
		String[] images = {"UniversityofLondon.jpg","UniversityofLondon1.jpg","UniversityofLondon2.jpg","UniversityofLondon3.jpg"};
		UniversityDetails undetails = new UniversityDetails(2, "University of London", "Senate House Malet Street London WC1E 7HU", courses, 4.4, departments, description, images, "Telephone: +44 (0)20 7862 8000.");
				
		this.universityRepo.save(undetails);
	
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
