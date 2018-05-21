package com.amtica.hrms.paypal;

import java.util.List;

public interface PayPalService {

	PayPalDTO addAccountDetails(PayPalDTO dto);

	List<PayPalDTO> getAccountDetails();

	PayPalDTO updateAccountDetails(PayPalDTO payPalDTO);

	PayPalDTO changeAccountStatus(Integer id, Boolean isDeleted);

}
