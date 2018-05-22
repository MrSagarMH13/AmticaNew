package com.amtica.hrms.institute.branch;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImpl implements BranchService{

	@Autowired
	BranchRepository branchRepo;
	
	@Override
	public BranchesDTO addBranch(BranchesDTO dto) {
		// TODO Auto-generated method stub
		
		Branches branches = BranchMapper.mapToModel(dto);
		branches = branchRepo.save(branches);
		
		return dto;
	}

	@Override
	public BranchesDTO getBranches(Integer branchId) {
		// TODO Auto-generated method stub
		
		Branches branches = branchRepo.findByBranchId(branchId);
		BranchesDTO  branchesDTO = BranchMapper.mapToDTO(branches);
		
		return branchesDTO;
	}

	@Override
	public BranchesDTO updateBranches(BranchesDTO dto) {
		// TODO Auto-generated method stub
		Branches branches = branchRepo.findByBranchId(dto.getBranchId());
		branches = BranchMapper.mapToModel(dto, branches);
		branches = branchRepo.saveAndFlush(branches);
		
		BranchesDTO branchesDTO = BranchMapper.mapToDTO(branches);
		return branchesDTO;
	}

	@Override
	public BranchesDTO deleteIBranch(Integer branchId, Boolean isTrue) {
		// TODO Auto-generated method stub
		
		BranchesDTO branchesDTO = null;
		Optional<Branches> found = branchRepo.findById(branchId);
		if(found.isPresent()){
			
			Branches deleted = found.get();
			deleted.setIsTrue(isTrue);
			branchRepo.saveAndFlush(deleted);
			branchesDTO = BranchMapper.mapToDTO(deleted);
			
			
		}
		
		return branchesDTO;
	}

}
