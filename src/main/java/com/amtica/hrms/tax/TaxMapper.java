package com.amtica.hrms.tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class TaxMapper {

	static List<TaxDTO> mapEntitiesIntoDTOs(Iterable<Tax> entities) {
		List<TaxDTO> dtos = new ArrayList<>();
		entities.forEach(e -> dtos.add(mapModelToDTO(e)));
		return dtos;
	}

	public static TaxDTO mapModelToDTO(Tax tax) {
		TaxDTO taxDTO = new TaxDTO();
		taxDTO.setTaxId(tax.getTaxId().toString());
		taxDTO.setCountryName(tax.getCountryName());
		taxDTO.setCountryCode(tax.getCountryCode());
		if (tax.getFlag() != null)
			taxDTO.setFlag(tax.getFlag());
		else
			taxDTO.setFlag(null);
		return taxDTO;
	}

	public static Tax mapDtoToModel(TaxDTO dto, Tax oldTax) {
		Tax tax = oldTax;
		if (tax == null)
			tax = new Tax();
		tax.set_Tax(new BigDecimal(dto.get_Tax()));
		tax.setCountryCode(dto.getCountryCode());
		tax.setCountryName(dto.getCountryName());
		if (dto.getFlag() != null) {
			tax.setFlag(dto.getFlag());
		}
		return tax;
	}
}
