package com.amtica.hrms.paypal;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayPalServiceImpl implements PayPalService {

	private final static Logger logger = LoggerFactory.getLogger(PayPalServiceImpl.class);

	@Autowired
	PayPalRepository payPalRepository;

	@Override
	public PayPalDTO addAccountDetails(PayPalDTO dto) {
		logger.info("************* addAccountDetails() START *************");
		PayPalDTO payPalDTO = null;
		try {
			PayPal newPayPal = PayPalMapper.mapDtoToModel(dto, null);
			newPayPal = payPalRepository.save(newPayPal);
			payPalDTO = PayPalMapper.mapModelToDTO(newPayPal);
		} catch (Exception e) {
			logger.error("************* addAccountDetails() ERROR *************" + e.toString());
		}
		logger.info("************* addAccountDetails() END *************");
		return payPalDTO;

	}

	@Override
	public List<PayPalDTO> getAccountDetails() {
		logger.info("************* getAccountDetails() START *************");
		List<PayPalDTO> payPalDTOs = null;
		try {
			List<PayPal> details = payPalRepository.findAll();
			payPalDTOs = PayPalMapper.mapEntitiesIntoDTOs(details);
		} catch (Exception e) {
			logger.error("************* getAccountDetails() ERROR *************" + e.toString());
		}
		logger.info("************* getAccountDetails() END *************");
		return payPalDTOs;
	}

	@Override
	public PayPalDTO updateAccountDetails(PayPalDTO dto) {
		logger.info("************* updateAccountDetails() START *************");
		PayPalDTO payPalDTO = null;
		try {
			Optional<PayPal> found = payPalRepository.findById(Integer.parseInt(dto.getId()));
			// We need to flush the changes or otherwise the returned object
			// doesn't contain the updated audit information.
			if (found.isPresent()) {
				PayPal updated = found.get();
				updated = PayPalMapper.mapDtoToModel(dto, updated);
				payPalRepository.saveAndFlush(updated);
				logger.info("Updated the information of the feature entry: {}", updated);
				return PayPalMapper.mapModelToDTO(updated);
			}
		} catch (Exception e) {
			logger.error("************* updateAccountDetails() ERROR *************" + e.toString());
		}
		logger.info("************* updateAccountDetails() END *************");
		return payPalDTO;
	}

	@Override
	public PayPalDTO changeAccountStatus(Integer id, Boolean isActive) {
		logger.info("************* changeAccountStatus() START *************");
		PayPalDTO payPalDTO = null;
		try {
			Optional<PayPal> found = payPalRepository.findById(id);
			if (found.isPresent()) {
				PayPal deleted = found.get();
				logger.debug("Found feature entry: {}", deleted);
				deleted.setIsActive(isActive);
				payPalRepository.saveAndFlush(deleted);
				logger.info("Deleted feature entry: {}", deleted);
				return PayPalMapper.mapModelToDTO(deleted);
			}
		} catch (Exception e) {
			logger.error("************* changeAccountStatus() ERROR *************" + e.toString());
		}
		logger.info("************* changeAccountStatus() END *************");
		return payPalDTO;
	}

}
