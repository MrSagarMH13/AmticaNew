package com.amtica.hrms.institute.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amtica.hrms.institute.InstituteDTO;

@RestController
@RequestMapping("branch")
public class BranchController {

	
	@Autowired
	BranchService branchService;
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<BranchesDTO> addBranch(@RequestBody BranchesDTO dto){
		
		BranchesDTO branchesDTO = branchService.addBranch(dto);
						
		return new ResponseEntity<BranchesDTO>(branchesDTO, new HttpHeaders(),
				branchesDTO!=null?HttpStatus.CREATED:HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	@RequestMapping(value="/get/{branchId}", method=RequestMethod.GET)
	public ResponseEntity<BranchesDTO> getBranches(@PathVariable Integer branchId){
		
		BranchesDTO branchesDTO = branchService.getBranches(branchId);
		
		return new ResponseEntity<BranchesDTO>(branchesDTO, new HttpHeaders(),
				branchesDTO!=null?HttpStatus.CREATED:HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.PUT)
	public ResponseEntity<BranchesDTO> updateBranches(@RequestBody BranchesDTO dto){
		
		BranchesDTO branchesDTO = branchService.updateBranches(dto);
		
		return new ResponseEntity<BranchesDTO>(branchesDTO, new HttpHeaders(),
				branchesDTO!=null?HttpStatus.CREATED:HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@RequestMapping(value="/delete/{branchId}/{isTrue}", method=RequestMethod.GET )
	public ResponseEntity<BranchesDTO> getById(@PathVariable Integer branchId, @PathVariable("isTrue") Boolean isTrue){
		
		BranchesDTO branchesDTO = branchService.deleteIBranch(branchId, isTrue);
		
		return new ResponseEntity<BranchesDTO>(branchesDTO, new HttpHeaders(),
				branchesDTO!=null? HttpStatus.CREATED:HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
