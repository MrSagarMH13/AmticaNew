package com.amtica.hrms.institute;

import com.amtica.hrms.tax.Tax;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class InstituteDTO {
	
	private Integer instituteId;
	private String contact;
	private String registrationNum;
	private String ownerEmailId;
	private Integer minUsercount;
	private String selectedPlan;
	private Integer countryId;
	private String pass;
	private boolean isDeleted;
	
	@JsonIgnore
	private Tax myTax;

	
	
	
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRegistrationNum() {
		return registrationNum;
	}

	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}

	public String getOwnerEmailId() {
		return ownerEmailId;
	}

	public void setOwnerEmailId(String ownerEmailId) {
		this.ownerEmailId = ownerEmailId;
	}

	public Integer getMinUsercount() {
		return minUsercount;
	}

	public void setMinUsercount(Integer minUsercount) {
		this.minUsercount = minUsercount;
	}

	public String getSelectedPlan() {
		return selectedPlan;
	}

	public void setSelectedPlan(String selectedPlan) {
		this.selectedPlan = selectedPlan;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Tax getMyTax() {
		return myTax;
	}

	public void setMyTax(Tax myTax) {
		this.myTax = myTax;
	}
	
	
	

}
