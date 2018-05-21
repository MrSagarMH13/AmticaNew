package com.amtica.hrms.tax;

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
@RequestMapping("tax")
public class TaxController {

	@Autowired
	TaxService taxService;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ResponseEntity<TaxDTO> createTax(@RequestBody TaxDTO dto) {
		TaxDTO response = taxService.createTax(dto);
		return new ResponseEntity<TaxDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<List<TaxDTO>> getTaxes() {
		List<TaxDTO> response = taxService.getTaxes();
		return new ResponseEntity<List<TaxDTO>>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public ResponseEntity<TaxDTO> uodateTax(@RequestBody TaxDTO dto) {
		TaxDTO response = taxService.uodateTax(dto);
		return new ResponseEntity<TaxDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/status/{id}/{isActive}", method = RequestMethod.GET)
	public ResponseEntity<TaxDTO> changeStaus(@PathVariable("id") Integer id,
			@PathVariable("isActive") Boolean isActive) {
		TaxDTO response = taxService.changeStaus(id, isActive);
		return new ResponseEntity<TaxDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
