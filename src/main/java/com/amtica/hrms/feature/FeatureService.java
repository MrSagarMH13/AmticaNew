package com.amtica.hrms.feature;

import java.util.List;

public interface FeatureService {

	FeatureDTO addFeature(FeatureDTO feature);

	List<FeatureDTO> getAll();

	FeatureDTO updateFeature(FeatureDTO feature);

	FeatureDTO deleteFeature(Integer id, Boolean isDeleted);

}
