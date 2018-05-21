package com.amtica.hrms.tax;

import java.util.List;

public interface TaxService {

	TaxDTO createTax(TaxDTO dto);

	List<TaxDTO> getTaxes();

	TaxDTO uodateTax(TaxDTO dto);

	TaxDTO changeStaus(Integer id, Boolean isActive);

}
