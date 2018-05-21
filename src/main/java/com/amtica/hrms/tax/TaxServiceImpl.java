package com.amtica.hrms.tax;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceImpl implements TaxService {

	private final static Logger logger = LoggerFactory.getLogger(TaxServiceImpl.class);

	@Autowired
	TaxRespository taxRepo;

	@Override
	public TaxDTO createTax(TaxDTO dto) {
		logger.info("************* createTax() START *************");
		TaxDTO taxDTO = null;
		try {
			Tax newSMTP = TaxMapper.mapDtoToModel(dto, null);
			taxDTO = TaxMapper.mapModelToDTO(taxRepo.save(newSMTP));
		} catch (Exception e) {
			logger.error("************* createTax() ERROR *************" + e.toString());
		}
		logger.info("************* createTax() END *************");
		return taxDTO;
	}

	@Override
	public List<TaxDTO> getTaxes() {
		logger.info("************* getTaxes() START *************");
		List<TaxDTO> taxDTOs = null;
		try {
			List<Tax> details = taxRepo.findAll();
			taxDTOs = TaxMapper.mapEntitiesIntoDTOs(details);
		} catch (Exception e) {
			logger.error("************* getTaxes() ERROR *************" + e.toString());
		}
		logger.info("************* getTaxes() END *************");
		return taxDTOs;
	}

	@Override
	public TaxDTO uodateTax(TaxDTO dto) {
		logger.info("************* uodateTax() START *************");
		TaxDTO taxDTO = null;
		try {
			Optional<Tax> found = taxRepo.findById(Integer.parseInt(dto.getTaxId()));
			// We need to flush the changes or otherwise the returned object
			// doesn't contain the updated audit information.
			if (found.isPresent()) {
				Tax updated = found.get();
				updated = TaxMapper.mapDtoToModel(dto, updated);
				taxRepo.saveAndFlush(updated);
				logger.info("Updated the information of the feature entry: {}", updated);
				return TaxMapper.mapModelToDTO(updated);
			}
		} catch (Exception e) {
			logger.error("************* uodateTax() ERROR *************" + e.toString());
		}
		logger.info("************* uodateTax() END *************");
		return taxDTO;
	}

	@Override
	public TaxDTO changeStaus(Integer id, Boolean isActive) {
		logger.info("************* changeStaus() START *************");
		TaxDTO taxDTO = null;
		try {
			Optional<Tax> found = taxRepo.findById(id);
			if (found.isPresent()) {
				Tax deleted = found.get();
				logger.debug("Found feature entry: {}", deleted);
				deleted.setIsActive(isActive);
				taxRepo.saveAndFlush(deleted);
				logger.info("Deleted feature entry: {}", deleted);
				return TaxMapper.mapModelToDTO(deleted);
			}
		} catch (Exception e) {
			logger.error("************* changeStaus() ERROR *************" + e.toString());
		}
		logger.info("************* changeStaus() END *************");
		return taxDTO;
	}

}
