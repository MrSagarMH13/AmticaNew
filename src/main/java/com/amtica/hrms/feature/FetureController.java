package com.amtica.hrms.feature;

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
@RequestMapping("features")
public class FetureController {

	@Autowired
	FeatureService featureService;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ResponseEntity<FeatureDTO> addFeature(@RequestBody FeatureDTO feature) {
		FeatureDTO response = featureService.addFeature(feature);
		return new ResponseEntity<FeatureDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<FeatureDTO>> getAll() {
		List<FeatureDTO> response = featureService.getAll();
		return new ResponseEntity<List<FeatureDTO>>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/feature/edit", method = RequestMethod.PUT)
	public ResponseEntity<FeatureDTO> updateFeature(@RequestBody FeatureDTO feature) {
		FeatureDTO response = featureService.updateFeature(feature);
		return new ResponseEntity<FeatureDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/feature/delete/{id}/{isDeleted}", method = RequestMethod.GET)
	public ResponseEntity<FeatureDTO> deleteFeature(@PathVariable("id") Integer id,
			@PathVariable("isDeleted") Boolean isDeleted) {
		FeatureDTO response = featureService.deleteFeature(id, isDeleted);
		return new ResponseEntity<FeatureDTO>(response, new HttpHeaders(),
				response != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
