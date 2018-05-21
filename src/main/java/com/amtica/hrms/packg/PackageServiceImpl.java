package com.amtica.hrms.packg;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.amtica.hrms.feature.Feature;
import com.amtica.hrms.feature.FeatureRepository;
import com.amtica.hrms.packg.details.PackageDetail;
import com.amtica.hrms.packg.details.PackageDetailRepository;
import com.amtica.hrms.packg.details.PackageDetailsDTO;
import com.amtica.hrms.packg.details.PackageDetailsMapper;

@Service
public class PackageServiceImpl implements PackageService {

	private final static Logger logger = LoggerFactory.getLogger(PackageServiceImpl.class);

	@Autowired
	PackageRepository packageRepository;

	@Autowired
	PackageDetailRepository detailRepo;

	@Autowired
	FeatureRepository featureRepo;

	public PackageDTO addPackage(PackageDTO packageDto) {
		logger.info("************* addPackage() START *************");
		PackageDTO newPackageDTO = null;
		try {
			List<PackageDetail> packageDetails = new ArrayList<>();
			Package newPackage = PackageMapper.mapDtoToModel(packageDto, null);
			newPackage = packageRepository.save(newPackage);
			for (PackageDetailsDTO detailsDTO : packageDto.getPackageDetails()) {
				Feature feature = featureRepo.findById(Integer.parseInt(detailsDTO.getFeatureId())).get();
				PackageDetail packageDetail = PackageDetailsMapper.mapDtoToModel(detailsDTO, null);
				packageDetail.setFeature(feature);
				packageDetail.setPackageId(newPackage.getPackageId());
				detailRepo.save(packageDetail);
				packageDetails.add(packageDetail);
			}
			newPackageDTO = PackageMapper.mapModelToDTO(newPackage);
			newPackageDTO.setPackageDetails(PackageDetailsMapper.mapEntitiesIntoDTOs(packageDetails));
		} catch (Exception e) {
			logger.error("************* addPackage() ERROR *************" + e.toString());
		}
		logger.info("************* addPackage() END *************");
		return newPackageDTO;
	}

	public List<PackageDTO> getAll() {
		logger.info("************* getAll() START *************");
		List<PackageDTO> packageDTOs = null;
		try {
			List<Package> packages = packageRepository.findAll();
			packageDTOs = PackageMapper.mapEntitiesIntoDTOs(packages);
			for (PackageDTO packageDTO : packageDTOs) {
				packageDTO.setPackageDetails(PackageDetailsMapper.mapEntitiesIntoDTOs(
						detailRepo.findPackageDetailsByPackageId(Integer.parseInt(packageDTO.getPackageId()))));
			}
		} catch (Exception e) {
			logger.error("************* getAll() ERROR *************" + e.toString());
		}
		logger.info("************* getAll() END *************");
		return packageDTOs;
	}

	public PackageDTO updatePackage(PackageDTO packageDto) {
		logger.info("************* updateFeature() START *************");
		PackageDTO packageDTO = null;
		try {
			Optional<Package> found = packageRepository.findById(Integer.parseInt(packageDto.getPackageId()));
			// We need to flush the changes or otherwise the returned object
			// doesn't contain the updated audit information.
			if (found.isPresent()) {
				Package updated = found.get();
				updated = PackageMapper.mapDtoToModel(packageDto, updated);
				packageRepository.saveAndFlush(updated);
				logger.info("Updated the information of the feature entry: {}", updated);
				for (PackageDetailsDTO detailsDTO : packageDto.getPackageDetails()) {
					Feature feature = featureRepo.findById(Integer.parseInt(detailsDTO.getFeatureId())).get();
					PackageDetail packageDetail = null;
					if (!StringUtils.isEmpty(detailsDTO.getId())) {
						packageDetail = detailRepo.findById(Integer.parseInt(detailsDTO.getId())).get();
						packageDetail = PackageDetailsMapper.mapDtoToModel(detailsDTO, packageDetail);
					} else {
						packageDetail = PackageDetailsMapper.mapDtoToModel(detailsDTO, null);
					}
					packageDetail.setFeature(feature);
					packageDetail.setPackageId(updated.getPackageId());
					detailRepo.save(packageDetail);
				}
				packageDTO = PackageMapper.mapModelToDTO(updated);
				packageDTO.setPackageDetails(PackageDetailsMapper
						.mapEntitiesIntoDTOs(detailRepo.findPackageDetailsByPackageId(updated.getPackageId())));
			}
		} catch (Exception e) {
			logger.error("************* updateFeature() ERROR *************" + e.toString());
		}
		logger.info("************* updateFeature() END *************");
		return packageDTO;
	}

	public PackageDTO deletePackage(Integer id, Boolean isActive) {
		logger.info("************* deleteFeature() START *************");
		PackageDTO packageDTO = null;
		try {
			Optional<Package> found = packageRepository.findById(id);
			if (found.isPresent()) {
				Package deleted = found.get();
				logger.debug("Found feature entry: {}", deleted);
				deleted.setIsActive(isActive);
				packageRepository.saveAndFlush(deleted);
				logger.info("Deleted feature entry: {}", deleted);
				packageDTO = PackageMapper.mapModelToDTO(deleted);
				packageDTO.setPackageDetails(PackageDetailsMapper
						.mapEntitiesIntoDTOs(detailRepo.findPackageDetailsByPackageId(deleted.getPackageId())));
			}
		} catch (Exception e) {
			logger.error("************* deleteFeature() ERROR *************" + e.toString());
		}
		logger.info("************* deleteFeature() END *************");
		return packageDTO;
	}

}
