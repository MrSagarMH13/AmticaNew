package com.amtica.hrms.paypal;

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
@RequestMapping("paypal")
public class PayPalController {

	@Autowired
	PayPalService payPalService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<PayPalDTO> addAccountDetails(@RequestBody PayPalDTO dto) {
		PayPalDTO response = payPalService.addAccountDetails(dto);
		return new ResponseEntity<PayPalDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<List<PayPalDTO>> getAccountDetails() {
		List<PayPalDTO> response = payPalService.getAccountDetails();
		return new ResponseEntity<List<PayPalDTO>>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public ResponseEntity<PayPalDTO> updateAccountDetails(@RequestBody PayPalDTO payPalDTO) {
		PayPalDTO response = payPalService.updateAccountDetails(payPalDTO);
		return new ResponseEntity<PayPalDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/account/status/{id}/{isActive}", method = RequestMethod.GET)
	public ResponseEntity<PayPalDTO> changeAccountStatus(@PathVariable("id") Integer id,
			@PathVariable("isActive") Boolean isActive) {
		PayPalDTO response = payPalService.changeAccountStatus(id, isActive);
		return new ResponseEntity<PayPalDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
