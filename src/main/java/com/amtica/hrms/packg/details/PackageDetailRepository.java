package com.amtica.hrms.packg.details;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageDetailRepository extends JpaRepository<PackageDetail, Integer> {
	
	public List<PackageDetail> findPackageDetailsByPackageId(Integer packageId);

}
