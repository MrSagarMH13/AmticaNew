package com.amtica.hrms.packg;

import java.util.List;

public interface PackageService {

	PackageDTO addPackage(PackageDTO packageDto);

	List<PackageDTO> getAll();

	PackageDTO updatePackage(PackageDTO packageDto);

	PackageDTO deletePackage(Integer id, Boolean isActive);

}
