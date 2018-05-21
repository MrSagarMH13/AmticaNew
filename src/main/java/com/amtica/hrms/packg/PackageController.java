package com.amtica.hrms.packg;

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
@RequestMapping("packages")
public class PackageController {

	@Autowired
	PackageService packageService;

	@RequestMapping(value = "/package/new", method = RequestMethod.POST)
	public ResponseEntity<PackageDTO> addPackage(@RequestBody PackageDTO packageDto) {
		PackageDTO response = packageService.addPackage(packageDto);
		return new ResponseEntity<PackageDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<PackageDTO>> getAll() {
		List<PackageDTO> response = packageService.getAll();
		return new ResponseEntity<List<PackageDTO>>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/package/edit", method = RequestMethod.PUT)
	public ResponseEntity<PackageDTO> updateFeature(@RequestBody PackageDTO packageDto) {
		PackageDTO response = packageService.updatePackage(packageDto);
		return new ResponseEntity<PackageDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/package/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<PackageDTO> deleteFeature(@PathVariable("id") Integer id,
			@PathVariable("isActive") Boolean isActive) {
		PackageDTO response = packageService.deletePackage(id, isActive);
		return new ResponseEntity<PackageDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
