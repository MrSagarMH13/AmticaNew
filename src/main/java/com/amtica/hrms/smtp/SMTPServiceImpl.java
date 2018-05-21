package com.amtica.hrms.smtp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMTPServiceImpl implements SMTPService {

	private final static Logger logger = LoggerFactory.getLogger(SMTPServiceImpl.class);

	@Autowired
	SMTPRepository smtpRepo;

	@Override
	public SMTPDTO addAccountDetails(SMTPDTO dto) {
		logger.info("************* addAccountDetails() START *************");
		SMTPDTO smtpdto = null;
		try {
			Smtp newSMTP = SMTPMapper.mapDtoToModel(dto, null);
			smtpdto = SMTPMapper.mapModelToDTO(smtpRepo.save(newSMTP));
		} catch (Exception e) {
			logger.error("************* addAccountDetails() ERROR *************" + e.toString());
		}
		logger.info("************* addAccountDetails() END *************");
		return smtpdto;
	}

	@Override
	public List<SMTPDTO> getAccountDetails() {
		logger.info("************* getAccountDetails() START *************");
		List<SMTPDTO> smtpdtos = null;
		try {
			List<Smtp> details = smtpRepo.findAll();
			smtpdtos = SMTPMapper.mapEntitiesIntoDTOs(details);
		} catch (Exception e) {
			logger.error("************* getAccountDetails() ERROR *************" + e.toString());
		}
		logger.info("************* getAccountDetails() END *************");
		return smtpdtos;
	}

	@Override
	public SMTPDTO updateAccountDetails(SMTPDTO dto) {
		logger.info("************* updateAccountDetails() START *************");
		SMTPDTO smtpdto = null;
		try {
			Optional<Smtp> found = smtpRepo.findById(Integer.parseInt(dto.getId()));
			// We need to flush the changes or otherwise the returned object
			// doesn't contain the updated audit information.
			if (found.isPresent()) {
				Smtp updated = found.get();
				updated = SMTPMapper.mapDtoToModel(dto, updated);
				smtpRepo.saveAndFlush(updated);
				logger.info("Updated the information of the feature entry: {}", updated);
				return SMTPMapper.mapModelToDTO(updated);
			}
		} catch (Exception e) {
			logger.error("************* updateAccountDetails() ERROR *************" + e.toString());
		}
		logger.info("************* updateAccountDetails() END *************");
		return smtpdto;
	}

	@Override
	public SMTPDTO changeAccountStatus(Integer id, Boolean isActive) {
		logger.info("************* changeAccountStatus() START *************");
		SMTPDTO smtpdto = null;
		try {
			Optional<Smtp> found = smtpRepo.findById(id);
			if (found.isPresent()) {
				Smtp deleted = found.get();
				logger.debug("Found feature entry: {}", deleted);
				deleted.setIsActive(isActive);
				smtpRepo.saveAndFlush(deleted);
				logger.info("Deleted feature entry: {}", deleted);
				return SMTPMapper.mapModelToDTO(deleted);
			}
		} catch (Exception e) {
			logger.error("************* changeAccountStatus() ERROR *************" + e.toString());
		}
		logger.info("************* changeAccountStatus() END *************");
		return smtpdto;
	}

}
