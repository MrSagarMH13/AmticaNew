package com.amtica.hrms.feature;

import java.util.ArrayList;
import java.util.List;

final public class FeatureMapper {

	static List<FeatureDTO> mapEntitiesIntoDTOs(Iterable<Feature> entities) {
		List<FeatureDTO> dtos = new ArrayList<>();
		entities.forEach(e -> dtos.add(mapModelToDTO(e)));
		return dtos;
	}

	public static FeatureDTO mapModelToDTO(Feature feature) {
		FeatureDTO featureDTO = new FeatureDTO();
		featureDTO.setId(feature.getId().toString());
		featureDTO.setName(feature.getName());
		featureDTO.setDescription(feature.getDescription());
		featureDTO.setIsDeleted(feature.getIsDeleted());
		return featureDTO;
	}

	public static Feature mapDtoToModel(FeatureDTO dto, Feature oldFeature) {
		Feature feature = oldFeature;
		if (feature == null)
			feature = new Feature();
		feature.setName(dto.getName());
		feature.setDescription(dto.getDescription());
		return feature;
	}

}
