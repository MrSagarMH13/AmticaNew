package com.amtica.hrms.feature;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureServiceImpl implements FeatureService {

	private final static Logger logger = LoggerFactory.getLogger(FeatureServiceImpl.class);

	@Autowired
	FeatureRepository featureRepository;

	public FeatureDTO addFeature(FeatureDTO feature) {
		logger.info("************* addFeature() START *************");
		FeatureDTO featureDTO = null;
		try {
			Feature newFeature = FeatureMapper.mapDtoToModel(feature, null);
			featureDTO = FeatureMapper.mapModelToDTO(featureRepository.save(newFeature));
		} catch (Exception e) {
			logger.error("************* addFeature() ERROR *************" + e.toString());
		}
		logger.info("************* addFeature() END *************");
		return featureDTO;
	}

	public List<FeatureDTO> getAll() {
		logger.info("************* getAll() START *************");
		List<FeatureDTO> featureDTOs = null;
		try {
			List<Feature> features = featureRepository.findAll();
			featureDTOs = FeatureMapper.mapEntitiesIntoDTOs(features);
		} catch (Exception e) {
			logger.error("************* getAll() ERROR *************" + e.toString());
		}
		logger.info("************* getAll() END *************");
		return featureDTOs;
	}

	public FeatureDTO updateFeature(FeatureDTO feature) {
		logger.info("************* updateFeature() START *************");
		FeatureDTO featureDTO = null;
		try {
			Optional<Feature> found = featureRepository.findById(Integer.parseInt(feature.getId()));
			// We need to flush the changes or otherwise the returned object
			// doesn't contain the updated audit information.
			if (found.isPresent()) {
				Feature updated = found.get();
				updated = FeatureMapper.mapDtoToModel(feature, updated);
				featureRepository.saveAndFlush(updated);
				logger.info("Updated the information of the feature entry: {}", updated);
				return FeatureMapper.mapModelToDTO(updated);
			}
		} catch (Exception e) {
			logger.error("************* updateFeature() ERROR *************" + e.toString());
		}
		logger.info("************* updateFeature() END *************");
		return featureDTO;
	}

	public FeatureDTO deleteFeature(Integer id, Boolean isDelete) {
		logger.info("************* deleteFeature() START *************");
		FeatureDTO featureDTO = null;
		try {
			Optional<Feature> found = featureRepository.findById(id);
			if (found.isPresent()) {
				Feature deleted = found.get();
				logger.debug("Found feature entry: {}", deleted);
				deleted.setIsDeleted(isDelete);
				featureRepository.saveAndFlush(deleted);
				logger.info("Deleted feature entry: {}", deleted);
				return FeatureMapper.mapModelToDTO(deleted);
			}
		} catch (Exception e) {
			logger.error("************* deleteFeature() ERROR *************" + e.toString());
		}
		logger.info("************* deleteFeature() END *************");
		return featureDTO;
	}

}
