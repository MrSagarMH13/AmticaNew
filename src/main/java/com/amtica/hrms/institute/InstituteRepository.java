package com.amtica.hrms.institute;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteRepository  extends JpaRepository<Institute, Integer>{
	
	List<Institute> findAll();
	
	Institute findByInstituteId(Integer instituteId);

}
