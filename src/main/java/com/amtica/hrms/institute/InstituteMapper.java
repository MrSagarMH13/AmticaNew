package com.amtica.hrms.institute;

import com.amtica.hrms.tax.Tax;

public class InstituteMapper {
	
	public static Institute mapToModel(InstituteDTO instituteDTO){
		
		Institute newInstitute = new Institute();
		newInstitute.setContact(instituteDTO.getContact());
		newInstitute.setMinUserCount(instituteDTO.getMinUsercount());
		newInstitute.setOwnerEmailId(instituteDTO.getOwnerEmailId());
		newInstitute.setPass(instituteDTO.getPass());
		newInstitute.setRegistrationNum(instituteDTO.getRegistrationNum());
		newInstitute.setSelectedPlan(instituteDTO.getSelectedPlan());
		Tax tax = new Tax();
		tax.setTaxId(instituteDTO.getCountryId());
		newInstitute.setTax(tax);
		
		
		return newInstitute;
		
	}

	public static InstituteDTO mapToDTO(Institute institute) {
		// TODO Auto-generated method stub
		
		InstituteDTO dto = new InstituteDTO();
		dto.setContact(institute.getContact());
		dto.setInstituteId(institute.getInstituteId());
		//dto.setCountryId(institute.getTax().getTaxId());
		dto.setMinUsercount(institute.getMinUserCount());
		dto.setOwnerEmailId(institute.getOwnerEmailId());
		dto.setPass(institute.getPass());
		dto.setSelectedPlan(institute.getSelectedPlan());
		dto.setRegistrationNum(institute.getRegistrationNum());
		dto.setCountryId(institute.getTax().getTaxId());
		return dto;
	}

	public static Institute mapToModel(InstituteDTO dto, Institute institute) {
		// TODO Auto-generated method stub
		if(institute ==null){
			institute = new Institute();
		}
		
		institute.setInstituteId(dto.getInstituteId());
		institute.setContact(dto.getContact());
		institute.setMinUserCount(dto.getMinUsercount());
		institute.setOwnerEmailId(dto.getOwnerEmailId());
		institute.setRegistrationNum(dto.getRegistrationNum());
		institute.setSelectedPlan(dto.getSelectedPlan());
		institute.setPass(dto.getPass());
		
		return institute;
		
	}
	

}
