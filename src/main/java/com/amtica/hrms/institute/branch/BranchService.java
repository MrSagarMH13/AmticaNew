package com.amtica.hrms.institute.branch;

public interface BranchService {

	BranchesDTO addBranch(BranchesDTO dto);

	BranchesDTO getBranches(Integer brachId);

	BranchesDTO updateBranches(BranchesDTO dto);

	BranchesDTO deleteIBranch(Integer branchId, Boolean isTrue);

}
