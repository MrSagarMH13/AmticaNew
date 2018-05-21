package com.amtica.hrms.paypal;

import java.util.ArrayList;
import java.util.List;

public final class PayPalMapper {

	static List<PayPalDTO> mapEntitiesIntoDTOs(Iterable<PayPal> entities) {
		List<PayPalDTO> dtos = new ArrayList<>();
		entities.forEach(e -> dtos.add(mapModelToDTO(e)));
		return dtos;
	}

	public static PayPalDTO mapModelToDTO(PayPal payPal) {
		PayPalDTO payPalDTO = new PayPalDTO();
		payPalDTO.setId(payPal.getId().toString());
		payPalDTO.setKey(payPal.getKey());
		payPalDTO.setUserName(payPal.getUserName());
		payPalDTO.setPassword(payPal.getPassword());
		payPalDTO.setIsActive(payPal.getIsActive());
		return payPalDTO;
	}

	public static PayPal mapDtoToModel(PayPalDTO dto, PayPal oldPayPal) {
		PayPal payPal = oldPayPal;
		if (payPal == null)
			payPal = new PayPal();
		payPal.setKey(dto.getKey());
		payPal.setUserName(dto.getUserName());
		payPal.setPassword(dto.getPassword());
		return payPal;
	}

}
