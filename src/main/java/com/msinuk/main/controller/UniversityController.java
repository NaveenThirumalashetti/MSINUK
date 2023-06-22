package com.msinuk.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msinuk.main.model.University;
import com.msinuk.main.service.UniversityService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/")
public class UniversityController {
	
	@Autowired
	private UniversityService service;

	
	@GetMapping("/Universities")
	public List<University> getUniversities(){
		return this.service.getUniversities();
	}
	
	@GetMapping("/getUniversities")
	public List<University> getUniversitiesByName(@RequestParam("uname") String universityName, @RequestParam("cname") String courseName,
			@RequestParam("department") String department){
		return this.service.getUniversitiesByName(universityName);
	}
	@GetMapping("/getUniversity")
	public List<University> getUniversityByName(@RequestParam("uname") String universityName){
		return this.service.getUniversitiesByName(universityName);
	}

}
