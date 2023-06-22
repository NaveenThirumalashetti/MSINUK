package com.msinuk.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msinuk.main.model.UniversityDetails;

public interface UniversityDetailsRepo extends JpaRepository<UniversityDetails, Long>{

	UniversityDetails findByUniversityName(String universityName);

}
