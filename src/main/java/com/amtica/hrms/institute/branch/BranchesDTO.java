package com.amtica.hrms.institute.branch;

import com.amtica.hrms.institute.Institute;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BranchesDTO {
	
	private Integer branchId;
	private String branchName;
	private String branchAddress;
	private String emailAddress;
	private String pass;
	
	private Integer instituteId;
	private boolean isTrue;
	
	@JsonIgnore
	private Institute myInstitute;

	
	public boolean getIsTrue() {
		return isTrue;
	}

	public void setIsTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(Integer instituteId) {
		this.instituteId = instituteId;
	}

	public Institute getMyInstitute() {
		return myInstitute;
	}

	public void setMyInstitute(Institute myInstitute) {
		this.myInstitute = myInstitute;
	}
	
	

}
