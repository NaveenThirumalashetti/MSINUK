package com.msinuk.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msinuk.main.model.University;

@Repository
public interface UniversityRepo extends JpaRepository<University, Long>{

	List<University> findByUniversityName(String universityName);

}
