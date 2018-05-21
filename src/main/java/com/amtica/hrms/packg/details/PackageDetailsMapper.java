package com.amtica.hrms.packg.details;

import java.util.ArrayList;
import java.util.List;

import com.amtica.hrms.feature.Feature;

public final class PackageDetailsMapper {
	
	public static List<PackageDetailsDTO> mapEntitiesIntoDTOs(Iterable<PackageDetail> entities) {
		List<PackageDetailsDTO> dtos = new ArrayList<>();
		entities.forEach(e -> dtos.add(mapModelToDTO(e)));
		return dtos;
	}

	public static PackageDetailsDTO mapModelToDTO(PackageDetail packageDetail) {
		PackageDetailsDTO detailDTO = new PackageDetailsDTO();
		detailDTO.setId(packageDetail.getId().toString());
		Feature feature = packageDetail.getFeature(); 
		detailDTO.setFeatureId(feature.getId().toString());
		detailDTO.setFeatureName(feature.getName());
		detailDTO.setIsDeleted(feature.getIsDeleted());
		return detailDTO;
	}

	public static PackageDetail mapDtoToModel(PackageDetailsDTO dto, PackageDetail oldDetails) {
		PackageDetail detail = oldDetails;
		if (detail == null)
			detail = new PackageDetail();
		return detail;
	}
}
