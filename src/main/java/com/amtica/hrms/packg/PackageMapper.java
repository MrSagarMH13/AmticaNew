package com.amtica.hrms.packg;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class PackageMapper {

	static List<PackageDTO> mapEntitiesIntoDTOs(Iterable<Package> entities) {
		List<PackageDTO> dtos = new ArrayList<>();
		entities.forEach(e -> dtos.add(mapModelToDTO(e)));
		return dtos;
	}

	public static PackageDTO mapModelToDTO(Package myPackage) {
		PackageDTO packageDTO = new PackageDTO();
		packageDTO.setPackageId(myPackage.getPackageId().toString());
		packageDTO.setDescription(myPackage.getDescription());
		packageDTO.setIsActive(myPackage.getIsActive());
		packageDTO.setMinUserAllowed(myPackage.getMinUserAllowed().toString());
		packageDTO.setPackageName(myPackage.getPackageName());
		packageDTO.setPricePerUserPerMonth(myPackage.getPricePerUserPerMonth().toString());
		packageDTO.setPricePerUserPerYear(myPackage.getPricePerUserPerYear().toString());
		packageDTO.setTrialPeriodDays(myPackage.getTrialPeriodDays().toString());
		return packageDTO;
	}

	public static Package mapDtoToModel(PackageDTO dto, Package oldPackage) {
		Package myPackage = oldPackage;
		if (myPackage == null)
			myPackage = new Package();
		myPackage.setPackageName(dto.getPackageName());
		myPackage.setDescription(dto.getDescription());
		myPackage.setPricePerUserPerMonth(new BigDecimal(dto.getPricePerUserPerMonth()));
		myPackage.setPricePerUserPerYear(new BigDecimal(dto.getPricePerUserPerYear()));
		myPackage.setTrialPeriodDays(Integer.parseInt(dto.getTrialPeriodDays()));
		myPackage.setMinUserAllowed(Integer.parseInt(dto.getMinUserAllowed()));
		return myPackage;
	}

}
