package com.amtica.hrms.smtp;

import java.util.ArrayList;
import java.util.List;

public final class SMTPMapper {

	static List<SMTPDTO> mapEntitiesIntoDTOs(Iterable<Smtp> entities) {
		List<SMTPDTO> dtos = new ArrayList<>();
		entities.forEach(e -> dtos.add(mapModelToDTO(e)));
		return dtos;
	}

	public static SMTPDTO mapModelToDTO(Smtp smtp) {
		SMTPDTO smtpDTO = new SMTPDTO();
		smtpDTO.setId(smtp.getId().toString());
		smtpDTO.setServer(smtp.getServer());
		smtpDTO.setPort(smtp.getPort().toString());
		smtpDTO.setUserName(smtp.getUserName());
		smtpDTO.setPassword(smtp.getPassword());
		smtpDTO.setIsActive(smtp.getIsActive());
		return smtpDTO;
	}

	public static Smtp mapDtoToModel(SMTPDTO dto, Smtp oldSMTP) {
		Smtp smtp = oldSMTP;
		if (smtp == null)
			smtp = new Smtp();
		smtp.setServer(dto.getServer());
		smtp.setPort(Integer.parseInt(dto.getPort()));
		smtp.setUserName(dto.getUserName());
		smtp.setPassword(dto.getPassword());
		return smtp;
	}
}
