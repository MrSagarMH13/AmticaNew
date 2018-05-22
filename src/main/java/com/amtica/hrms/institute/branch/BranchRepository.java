package com.amtica.hrms.institute.branch;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branches, Integer>{

	List<Branches> findAll();
	
	Branches findByBranchId(Integer branchId);
}
