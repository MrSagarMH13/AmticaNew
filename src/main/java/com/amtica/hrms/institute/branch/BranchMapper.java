package com.amtica.hrms.institute.branch;

import com.amtica.hrms.institute.Institute;

public class BranchMapper {

	public static Branches mapToModel(BranchesDTO dto) {
		
		Branches branches = new Branches();
		branches.setBranchAddress(dto.getBranchAddress());
		branches.setBranchName(dto.getBranchName());
		branches.setEmailAddress(dto.getEmailAddress());
		
		Institute institute = new Institute();
		institute.setInstituteId(dto.getInstituteId());
		
		branches.setPass(dto.getPass());
		branches.setInstitute(institute);
		
		
		
		return branches;
	}

	public static BranchesDTO mapToDTO(Branches branches) {
		// TODO Auto-generated method stub
		BranchesDTO branchesDTO = new BranchesDTO();
		System.out.println(branches.getBranchAddress());
		branchesDTO.setBranchAddress(branches.getBranchAddress());
		branchesDTO.setBranchId(branches.getBranchId());
		branchesDTO.setBranchName(branches.getBranchName());
		branchesDTO.setEmailAddress(branches.getEmailAddress());
		branchesDTO.setPass(branches.getPass());
		branchesDTO.setInstituteId(branches.getInstitute().getInstituteId());
		branchesDTO.setIsTrue(branches.getIsTrue());
		
		return branchesDTO;
	}

	public static Branches mapToModel(BranchesDTO dto, Branches branches) {
		// TODO Auto-generated method stub

		if(branches==null){
			branches = new Branches();
		}
		
		branches.setBranchAddress(dto.getBranchAddress());
		branches.setBranchName(dto.getBranchName());
		branches.setEmailAddress(dto.getEmailAddress());
		branches.setPass(dto.getPass());
		branches.setBranchId(dto.getBranchId());
		
		return branches;
	}
	
	

}
