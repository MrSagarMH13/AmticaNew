package com.amtica.hrms.institute;

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
@RequestMapping("/api/institute")
public class InstituteController {
	
	@Autowired
	InstituteService instituteService;
	
	@RequestMapping(value="/add", method =RequestMethod.POST)
	public ResponseEntity<InstituteDTO> addInstitute(@RequestBody InstituteDTO dto){
		
		InstituteDTO instituteDTO = instituteService.addInstitute(dto);
		
		return new ResponseEntity<InstituteDTO>(instituteDTO, new HttpHeaders(),
				instituteDTO!=null? HttpStatus.CREATED:HttpStatus.INTERNAL_SERVER_ERROR);
						
	}
	
	@RequestMapping(value="/get/{instituteId}", method=RequestMethod.GET )
	public ResponseEntity<InstituteDTO> getById(@PathVariable Integer instituteId){
		
		InstituteDTO instituteDTO = instituteService.getByInstistuteId(instituteId);
		
		return new ResponseEntity<InstituteDTO>(instituteDTO, new HttpHeaders(),
				instituteDTO!=null? HttpStatus.CREATED:HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT )
	public ResponseEntity<InstituteDTO> getById(@RequestBody InstituteDTO dto){
		
		InstituteDTO instituteDTO = instituteService.updateInstitute(dto);
		
		return new ResponseEntity<InstituteDTO>(instituteDTO, new HttpHeaders(),
				instituteDTO!=null? HttpStatus.CREATED:HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@RequestMapping(value="/delete/{instituteId}/{isDeleted}", method=RequestMethod.GET )
	public ResponseEntity<InstituteDTO> getById(@PathVariable Integer instituteId, @PathVariable("isDeleted") Boolean isDeleted){
		
		InstituteDTO instituteDTO = instituteService.deleteInstitute(instituteId, isDeleted);
		
		return new ResponseEntity<InstituteDTO>(instituteDTO, new HttpHeaders(),
				instituteDTO!=null? HttpStatus.CREATED:HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
