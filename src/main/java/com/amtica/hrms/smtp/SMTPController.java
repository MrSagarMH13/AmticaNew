package com.amtica.hrms.smtp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("smtp")
public class SMTPController {

	@Autowired
	SMTPService smtpService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<SMTPDTO> addAccountDetails(@RequestBody SMTPDTO dto) {
		SMTPDTO response = smtpService.addAccountDetails(dto);
		return new ResponseEntity<SMTPDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<List<SMTPDTO>> getAccountDetails() {
		List<SMTPDTO> response = smtpService.getAccountDetails();
		return new ResponseEntity<List<SMTPDTO>>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public ResponseEntity<SMTPDTO> updateAccountDetails(@RequestBody SMTPDTO smtpDTO) {
		SMTPDTO response = smtpService.updateAccountDetails(smtpDTO);
		return new ResponseEntity<SMTPDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/account/status/{id}/{isActive}", method = RequestMethod.GET)
	public ResponseEntity<SMTPDTO> changeAccountStatus(@PathVariable("id") Integer id,
			@PathVariable("isActive") Boolean isActive) {
		SMTPDTO response = smtpService.changeAccountStatus(id, isActive);
		return new ResponseEntity<SMTPDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
