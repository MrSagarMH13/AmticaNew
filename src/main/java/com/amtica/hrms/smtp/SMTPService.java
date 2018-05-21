package com.amtica.hrms.smtp;

import java.util.List;

public interface SMTPService {

	SMTPDTO addAccountDetails(SMTPDTO dto);

	List<SMTPDTO> getAccountDetails();

	SMTPDTO updateAccountDetails(SMTPDTO payPalDTO);

	SMTPDTO changeAccountStatus(Integer id, Boolean isDeleted);

}
